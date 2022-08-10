package br.ufu.quiz.pooatividadefinalquiz.services;

import br.ufu.quiz.pooatividadefinalquiz.controllers.dto.GameDTO;
import br.ufu.quiz.pooatividadefinalquiz.enums.GameStatus;
import br.ufu.quiz.pooatividadefinalquiz.model.Game;
import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Log
public class GameService {

    private final QuestionService questionService;
    private final Game game;


    public GameService(QuestionService questionService) {
        this.questionService = questionService;
        this.game = new Game(questionService.findRandomQuestion());
    }

    public Game getGame() {
        return game;
    }

    public boolean answer(UUID uuid, int answer) {
        var user = game.getUsers().stream().filter(u -> u.getId().equals(uuid)).findFirst();
        if(user.isEmpty()) {
            return false;
        }

        var alreadyAnswered = game.getUsersWhoAnswered().keySet().stream().anyMatch(u -> u.getId().equals(user.get().getId()));
        if(alreadyAnswered) {
            return false;
        }

        game.getUsersWhoAnswered().put(user.get(), answer);
        return true;
    }

    @Scheduled(fixedRate = 5000)
    public void updateGameStatus() {
        if (game.getStatus() == GameStatus.WAITING_FOR_PLAYERS && game.getUsers().size() >= 2) {
            game.setStatus(GameStatus.IN_PROGRESS);
            game.setTimeUp(System.currentTimeMillis() + 12500L);
        } else if (game.getStatus() == GameStatus.IN_PROGRESS && System.currentTimeMillis() > game.getTimeUp()) {
            checkAnswers();
        } else if (game.getStatus() == GameStatus.FINISHED) {
            game.setStatus(GameStatus.WAITING_FOR_PLAYERS);
            game.getAlreadyAnsweredQuestions().clear();
            game.getUsersWhoAnswered().clear();
            game.getUsers().forEach(u -> u.setScore(0F));
        }

        log.info(new GameDTO(game).toString());
    }

    private void checkAnswers() {
        game.setStatus(GameStatus.GENERATING_NEXT_QUESTION);

        game.getUsersWhoAnswered().keySet().forEach(user -> {
            if (game.getUsersWhoAnswered().get(user) == game.getCurrentQuestion().getCorrectAnswer()) {
                user.setScore(user.getScore() + 1.5F);
            }
        });

        if(game.getAlreadyAnsweredQuestions().size() >= 4) {
            game.setStatus(GameStatus.FINISHED);
            return;
        }

        game.getAlreadyAnsweredQuestions().add(game.getCurrentQuestion().getId());

        new Timer().schedule(new TimerTask() {
            int i = 0;
            @Override
            public void run() {
                game.setCurrentQuestion(questionService.findRandomQuestion());

                while (game.getCurrentQuestion() == null || game.getAlreadyAnsweredQuestions().contains(game.getCurrentQuestion().getId())) {
                    if(i >= 15) {
                        game.setStatus(GameStatus.FINISHED);
                        break;
                    }

                    game.setCurrentQuestion(questionService.findRandomQuestion());
                    i++;
                }

                game.getUsersWhoAnswered().clear();
                game.setStatus(GameStatus.IN_PROGRESS);
                game.setTimeUp(System.currentTimeMillis() + 12500L);
            }
        }, 5000);
    }
}

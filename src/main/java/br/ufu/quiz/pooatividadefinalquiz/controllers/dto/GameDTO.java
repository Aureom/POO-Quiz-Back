package br.ufu.quiz.pooatividadefinalquiz.controllers.dto;

import br.ufu.quiz.pooatividadefinalquiz.enums.GameStatus;
import br.ufu.quiz.pooatividadefinalquiz.model.Game;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class GameDTO {

    private QuestionDTO currentQuestion;
    private List<UserCardDTO> users;
    private Set<UserCardDTO> usersWhoAnswered;
    private HashMap<UUID, String> chatMessages;
    private GameStatus status;
    private int percentageTimeLeft;


    public GameDTO(Game game) {
        this.currentQuestion = new QuestionDTO(game.getCurrentQuestion());
        this.users = game.getUsers().stream().map(UserCardDTO::new).collect(Collectors.toList());
        this.usersWhoAnswered = game.getUsersWhoAnswered().keySet().stream().map(UserCardDTO::new).collect(Collectors.toSet());
        this.chatMessages = game.getChatMessages();
        this.status = game.getStatus();
        this.percentageTimeLeft = getPercentageTimeLeft(game);

        if(users != null && !users.isEmpty()) sortUsers();
    }

    private int getPercentageTimeLeft(Game game) {
        return (int) ((System.currentTimeMillis() - game.getTimeUp()) * 100 / 12500) * -1;
    }

    private void sortUsers() {
        users.sort((u1, u2) ->  u2.getScore().compareTo(u1.getScore()));
    }
}

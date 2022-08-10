package br.ufu.quiz.pooatividadefinalquiz.model;

import br.ufu.quiz.pooatividadefinalquiz.entities.Question;
import br.ufu.quiz.pooatividadefinalquiz.entities.User;
import br.ufu.quiz.pooatividadefinalquiz.enums.GameStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Game {

    private Question currentQuestion;
    private Set<UUID> alreadyAnsweredQuestions;
    private Set<User> users;
    private HashMap<User, Integer> usersWhoAnswered;
    private HashMap<UUID, String> chatMessages;
    private GameStatus status;
    private long timeUp;

    public Game(Question question) {
        this.currentQuestion = question;
        this.alreadyAnsweredQuestions = new HashSet<>();
        this.users = new HashSet<>();
        this.usersWhoAnswered = new HashMap<>();
        this.chatMessages = new HashMap<>();
        status = GameStatus.WAITING_FOR_PLAYERS;
    }

}
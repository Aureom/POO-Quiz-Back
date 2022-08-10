package br.ufu.quiz.pooatividadefinalquiz.controllers.dto;

import br.ufu.quiz.pooatividadefinalquiz.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserCardDTO {

    private String username;

    private Float score;

    public UserCardDTO(User user) {
        this.username = user.getUsername();
        this.score = user.getScore();
    }
}

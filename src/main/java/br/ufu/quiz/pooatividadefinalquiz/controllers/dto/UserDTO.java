package br.ufu.quiz.pooatividadefinalquiz.controllers.dto;

import br.ufu.quiz.pooatividadefinalquiz.entities.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class UserDTO {

    private UUID id;
    private String username;


    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
    }
}

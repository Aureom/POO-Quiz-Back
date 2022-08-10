package br.ufu.quiz.pooatividadefinalquiz.entities;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String username;

    private Float score;

    public User(String username) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.score = 0F;
    }
}

package br.ufu.quiz.pooatividadefinalquiz.entities;

import br.ufu.quiz.pooatividadefinalquiz.enums.Category;
import br.ufu.quiz.pooatividadefinalquiz.enums.Difficulty;
import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue
    private UUID id;

    private String question;

    private String optionA, optionB, optionC, optionD;

    private String correctAnswer;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Enumerated(EnumType.STRING)
    private Category category;
}

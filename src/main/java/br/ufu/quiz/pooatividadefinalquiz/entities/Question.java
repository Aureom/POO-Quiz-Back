package br.ufu.quiz.pooatividadefinalquiz.entities;

import br.ufu.quiz.pooatividadefinalquiz.enums.Category;
import br.ufu.quiz.pooatividadefinalquiz.enums.Difficulty;
import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String question;

    private String optionA, optionB, optionC, optionD;

    private String correctAnswer;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @Enumerated(EnumType.STRING)
    private Category category;
}

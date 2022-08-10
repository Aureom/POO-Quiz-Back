package br.ufu.quiz.pooatividadefinalquiz.entities;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Question {

    @Id
    @GeneratedValue
    private UUID id;

    private String question;

    private String optionA, optionB, optionC, optionD;

    @Range(min = 0, max = 3)
    private int correctAnswer;
}

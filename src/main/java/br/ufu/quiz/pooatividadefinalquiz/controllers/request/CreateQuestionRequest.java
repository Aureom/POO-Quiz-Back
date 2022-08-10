package br.ufu.quiz.pooatividadefinalquiz.controllers.request;

import br.ufu.quiz.pooatividadefinalquiz.entities.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
public class CreateQuestionRequest {

    @NotNull
    private String question;

    @NotNull
    private String optionA;

    @NotNull
    private String optionB;

    @NotNull
    private String optionC;

    @NotNull
    private String optionD;

    @Range(min = 0, max = 3)
    private int correctAnswer;

    public Question toQuestion() {
        return Question.builder()
                .question(question)
                .optionA(optionA)
                .optionB(optionB)
                .optionC(optionC)
                .optionD(optionD)
                .correctAnswer(correctAnswer)
                .build();
    }
}

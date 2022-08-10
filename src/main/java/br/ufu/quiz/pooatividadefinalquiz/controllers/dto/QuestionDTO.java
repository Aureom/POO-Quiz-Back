package br.ufu.quiz.pooatividadefinalquiz.controllers.dto;

import br.ufu.quiz.pooatividadefinalquiz.entities.Question;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionDTO {

    private String question;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;


    public QuestionDTO(Question question) {
        this.question = question.getQuestion();
        this.optionA = question.getOptionA();
        this.optionB = question.getOptionB();
        this.optionC = question.getOptionC();
        this.optionD = question.getOptionD();
    }
}

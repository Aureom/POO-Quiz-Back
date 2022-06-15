package br.ufu.quiz.pooatividadefinalquiz.dto;

import br.ufu.quiz.pooatividadefinalquiz.entities.Question;
import br.ufu.quiz.pooatividadefinalquiz.enums.Category;
import br.ufu.quiz.pooatividadefinalquiz.enums.Difficulty;
import lombok.Data;

@Data
public class QuestionDTO {

    private long id;
    private String question;
    private String optionA, optionB, optionC, optionD;
    private Difficulty difficulty;
    private Category category;


    public QuestionDTO(Question question) {
        this.id = question.getId();
        this.question = question.getQuestion();
        this.optionA = question.getOptionA();
        this.optionB = question.getOptionB();
        this.optionC = question.getOptionC();
        this.optionD = question.getOptionD();
        this.difficulty = question.getDifficulty();
        this.category = question.getCategory();
    }
}

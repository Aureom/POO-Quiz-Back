package br.ufu.quiz.pooatividadefinalquiz.controllers;

import br.ufu.quiz.pooatividadefinalquiz.controllers.dto.QuestionDTO;
import br.ufu.quiz.pooatividadefinalquiz.controllers.request.CreateQuestionRequest;
import br.ufu.quiz.pooatividadefinalquiz.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/question")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<QuestionDTO> save(@Valid @RequestBody CreateQuestionRequest createQuestionRequest) {
        QuestionDTO questionDTO = questionService.save(createQuestionRequest.toQuestion());

        return ResponseEntity.status(HttpStatus.CREATED).body(questionDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable UUID id) {
        QuestionDTO question = this.questionService.findById(id);

        if (question == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(question);
    }

//    @GetMapping
//    public ResponseEntity<Object> findAll() {
//        List<QuestionDTO> questions = this.questionService.findAll();
//
//        if (questions.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No questions found");
//        }
//
//        return ResponseEntity.status(HttpStatus.OK).body(questions);
//    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id) {
        QuestionDTO question = this.questionService.delete(id);

        if (question == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Question not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(question);
    }
}

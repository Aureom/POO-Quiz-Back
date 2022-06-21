package br.ufu.quiz.pooatividadefinalquiz.controllers;

import br.ufu.quiz.pooatividadefinalquiz.dto.QuestionDTO;
import br.ufu.quiz.pooatividadefinalquiz.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<Object> save(@RequestBody QuestionDTO questionDTO) {
        QuestionDTO question = this.questionService.save(questionDTO);

        if (question == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Question already exists");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(question);
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

package br.ufu.quiz.pooatividadefinalquiz.services;

import br.ufu.quiz.pooatividadefinalquiz.dto.QuestionDTO;
import br.ufu.quiz.pooatividadefinalquiz.dto.UserDTO;
import br.ufu.quiz.pooatividadefinalquiz.entities.Question;
import br.ufu.quiz.pooatividadefinalquiz.entities.User;
import br.ufu.quiz.pooatividadefinalquiz.repositories.QuestionRepository;
import br.ufu.quiz.pooatividadefinalquiz.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public QuestionDTO save(QuestionDTO questionDTO) {
        Optional<Question> question = questionRepository.findById(questionDTO.getId());

        if (question.isPresent()) {
            throw new IllegalArgumentException("Question already exists");
        }

        Question newQuestion = Question.builder()
                .question(questionDTO.getQuestion())
                .optionA(questionDTO.getOptionA())
                .optionB(questionDTO.getOptionB())
                .optionC(questionDTO.getOptionC())
                .optionD(questionDTO.getOptionD())
                .difficulty(questionDTO.getDifficulty())
                .category(questionDTO.getCategory())
                .build();

        this.questionRepository.save(newQuestion);

        return new QuestionDTO(newQuestion);
    }

    public QuestionDTO delete(UUID id) {
        Optional<Question> question = questionRepository.findById(id);

        if (question.isEmpty()) {
            throw new IllegalArgumentException("Question not found");
        }

        Question deletedQuestion = question.get();
        questionRepository.delete(deletedQuestion);

        return new QuestionDTO(deletedQuestion);
    }

    public QuestionDTO findById(UUID id) {
        Optional<Question> question = questionRepository.findById(id);

        if (question.isEmpty()) {
            throw new IllegalArgumentException("Question not found");
        }

        return new QuestionDTO(question.get());
    }

// TODO: Implementar o método findRandomQuestion
//
//    public QuestionDTO findRandomQuestionByDifficulty(String difficulty) {
//        Optional<Question> question = questionRepository.findRandomQuestionByDifficulty(difficulty);
//
//        if (question.isEmpty()) {
//            throw new IllegalArgumentException("Question not found");
//        }
//
//        return new QuestionDTO(question.get());
//    }
}

package br.ufu.quiz.pooatividadefinalquiz.services;

import br.ufu.quiz.pooatividadefinalquiz.controllers.dto.QuestionDTO;
import br.ufu.quiz.pooatividadefinalquiz.entities.Question;
import br.ufu.quiz.pooatividadefinalquiz.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public QuestionDTO save(Question question) {
        Optional<Question> optionalQuestion = questionRepository.findByQuestion(question.getQuestion());

        if (optionalQuestion.isPresent()) {
            throw new IllegalArgumentException("Question already exists");
        }

        this.questionRepository.save(question);

        return new QuestionDTO(question);
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


    public Question findRandomQuestion() {
        List<Question> question = questionRepository.findAll();

        if (question.isEmpty()) {
            return null;
        }

        // get a random question from the list
        int randomIndex = (int) (Math.random() * question.size());
        return question.get(randomIndex);
    }
}

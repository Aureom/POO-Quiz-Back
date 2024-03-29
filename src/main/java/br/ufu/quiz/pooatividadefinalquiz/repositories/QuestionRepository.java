package br.ufu.quiz.pooatividadefinalquiz.repositories;

import br.ufu.quiz.pooatividadefinalquiz.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface QuestionRepository extends JpaRepository<Question, UUID> {

    Optional<Question> findByQuestion(String question);
}

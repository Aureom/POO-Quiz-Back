package br.ufu.quiz.pooatividadefinalquiz.repositories;

import br.ufu.quiz.pooatividadefinalquiz.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}

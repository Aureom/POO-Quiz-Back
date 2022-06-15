package br.ufu.quiz.pooatividadefinalquiz.repositories;

import br.ufu.quiz.pooatividadefinalquiz.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT user FROM User user WHERE user.email = :email")
    Optional<User> findByEmail(String email);
}

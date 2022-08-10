package br.ufu.quiz.pooatividadefinalquiz.services;

import br.ufu.quiz.pooatividadefinalquiz.controllers.dto.UserDTO;
import br.ufu.quiz.pooatividadefinalquiz.entities.User;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Log
public class UserService {

    private final GameService gameService;

    @Autowired
    public UserService(GameService gameService) {
        this.gameService = gameService;
    }

    public UserDTO addUser(String username) {
        if(gameService.getGame().getUsers().stream().anyMatch(u -> u.getUsername().equals(username))) {
            return null;
        }

        User newUser = new User(username);
        gameService.getGame().getUsers().add(newUser);
        return new UserDTO(newUser);
    }

    public UserDTO tryLogin(UUID uuid, String username) {
        Optional<User> user = gameService.getGame().getUsers().stream().filter(u -> u.getUsername().equals(username)).findFirst();
        if(user.isPresent() && user.get().getId().equals(uuid)) {
            return new UserDTO(user.get());
        }

        return null;
    }
}

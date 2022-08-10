package br.ufu.quiz.pooatividadefinalquiz.controllers;

import br.ufu.quiz.pooatividadefinalquiz.controllers.dto.UserDTO;
import br.ufu.quiz.pooatividadefinalquiz.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<Object> usernameIsAvailable(@PathVariable String username) {
        var userDTO = this.userService.addUser(username);

        if (userDTO == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Nome de usuário já está em uso");
        }

        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }

    @PostMapping
    public ResponseEntity<Object> tryLogin(@RequestBody UserDTO userDTO) {
        var optionalUser = this.userService.tryLogin(userDTO.getId(), userDTO.getUsername());

        if (optionalUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado");
        }

        return ResponseEntity.status(HttpStatus.OK).body(optionalUser);
    }
}

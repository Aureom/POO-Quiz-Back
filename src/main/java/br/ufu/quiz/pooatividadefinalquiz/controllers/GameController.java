package br.ufu.quiz.pooatividadefinalquiz.controllers;

import br.ufu.quiz.pooatividadefinalquiz.controllers.dto.GameDTO;
import br.ufu.quiz.pooatividadefinalquiz.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<GameDTO> getGame() {
        if(gameService.getGame() == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.status(HttpStatus.OK).body(new GameDTO(gameService.getGame()));
    }

    @PostMapping("/answer")
    public ResponseEntity<GameDTO> answer(@RequestParam UUID uuid, @RequestParam int answer) {
        if(gameService.getGame() == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        if(gameService.answer(uuid, answer))
            return ResponseEntity.status(HttpStatus.OK).body(new GameDTO(gameService.getGame()));
        else
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}

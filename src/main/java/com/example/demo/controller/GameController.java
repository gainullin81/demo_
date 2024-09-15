package com.example.demo.controller;

import com.example.demo.model.Game;
import com.example.demo.model.Move;
import com.example.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public Game getGameState() {
        return gameService.getGameState();
    }

    @PostMapping("/move")
    public Game makeMove(@RequestBody Move move) {
        return gameService.makeMove(move.getIndex());
    }
}

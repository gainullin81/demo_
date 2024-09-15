package com.example.demo.service;

import com.example.demo.model.Game;

import org.springframework.stereotype.Service;

@Service
public class GameService {

    private Game gameState = new Game();

    public Game getGameState() {
        return gameState;
    }

    public Game makeMove(int index) {
        if (gameState.getBoard()[index] != null || calculateWinner(gameState.getBoard()) != null) {

            return gameState;
          }

        gameState.getBoard()[index] = gameState.isXIsNext() ? "X" : "O";
        gameState.setXIsNext(!gameState.isXIsNext());

        return gameState;
    }

    private String calculateWinner(String[] board){
        String[][] lines = {
                {board[0], board[1], board[2]},
                {board[3], board[4], board[5]},
                {board[6], board[7], board[8]},
                {board[0], board[3], board[6]},
                {board[1], board[4], board[7]},
                {board[2], board[5], board[8]},
                {board[0], board[4], board[8]},
                {board[2], board[4], board[6]},
        };

        for (String[] line : lines){
            if (line[0] != null && line[0].equals(line[1]) && line[0].equals(line[2])){
                return line[0];
 }
        }
        return null;
    }
}

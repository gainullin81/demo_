// src/main/java/com/example/demo/model/Game.java
package com.example.demo.model;

public class Game {
    private String[] board = new String[9];
    private boolean xIsNext = true;

    public String[] getBoard() {
        return board;
    }

    public void setBoard(String[] board) {
        this.board = board;
    }

    public boolean isXIsNext() {
        return xIsNext;
    }

    public void setXIsNext(boolean xIsNext) {
        this.xIsNext = xIsNext;
    }
}
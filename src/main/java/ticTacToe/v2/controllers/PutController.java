package ticTacToe.v2.controllers;

import ticTacToe.v2.models.Board;
import ticTacToe.v2.models.Turn;

public class PutController extends CoordinateController {

    public PutController(Board board, Turn turn) {
        super(board, turn);
    }

    @Override
    public void control() {
        this.control("Pone", "En");
    }

    @Override
    protected void colocate(String targetTitle) {
        this.put(targetTitle);
    }
}
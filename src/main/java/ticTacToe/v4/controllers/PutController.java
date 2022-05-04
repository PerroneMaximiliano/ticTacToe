package ticTacToe.v4.controllers;

import ticTacToe.v4.models.Game;

public class PutController extends CoordinateController {

    public PutController(Game game) {
        super(game, "Pone");
    }

    @Override
    protected void colocate() {
        this.put();
    }
}
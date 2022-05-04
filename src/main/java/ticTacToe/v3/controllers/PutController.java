package ticTacToe.v3.controllers;

import ticTacToe.v3.models.Game;

public class PutController extends CoordinateController {

    public PutController(Game game) {
        super(game, "Pone");
    }

    @Override
    protected void colocate() {
        this.put();
    }
}
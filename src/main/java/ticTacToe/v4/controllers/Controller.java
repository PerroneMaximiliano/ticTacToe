package ticTacToe.v4.controllers;

import ticTacToe.v4.models.Board;
import ticTacToe.v4.models.Game;
import ticTacToe.v4.models.Turn;
import ticTacToe.v4.utils.State;

/**
 * @author maxip
 */

public abstract class Controller {
    private Game game;

    protected Controller(Game game) {
        this.game = game;
    }

    public abstract void control();

    protected Turn getTurn() {
        return game.getTurn();
    }

    protected Board getBoard() {
        return game.getBoard();
    }

    public void setState(State state) {
        game.setState(state);
    }
}

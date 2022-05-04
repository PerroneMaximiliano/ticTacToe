package ticTacToe.v4.controllers;

import ticTacToe.v4.models.Game;
import ticTacToe.v4.utils.State;

/**
 * @author maxip
 */

public class StartController extends Controller {

    public StartController(Game game) {
        super(game);
    }

    @Override
    public void control() {
        this.getBoard().write();
        this.setState(State.IN_GAME);
    }
}

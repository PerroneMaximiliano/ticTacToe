package ticTacToe.v3.controllers;

import ticTacToe.v3.models.Game;
import ticTacToe.v3.utils.State;

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

package ticTacToe.v3.models;

import ticTacToe.v3.controllers.Controller;
import ticTacToe.v3.controllers.MoveController;
import ticTacToe.v3.controllers.PutController;
import ticTacToe.v3.controllers.StartController;

/**
 * @author maxip
 */

public class Logic {

    private Game game;

    private StartController startController;

    private PutController putController;

    private MoveController moveController;

    public Logic() {
        this.game = new Game();
        this.startController = new StartController(game);
        this.putController = new PutController(game);
        this.moveController = new MoveController(game);
    }

    public Controller getController() {
        switch (game.getState()) {
            case INITIAL:
                return startController;
            case IN_GAME:
                return game.getBoard().complete() ? moveController : putController;
            case FINAL:
            default:
                return null;
        }
    }
}

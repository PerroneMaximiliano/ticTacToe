package ticTacToe.v4.models;

import ticTacToe.v4.controllers.ContinueController;
import ticTacToe.v4.controllers.Controller;
import ticTacToe.v4.controllers.MoveController;
import ticTacToe.v4.controllers.PutController;
import ticTacToe.v4.controllers.StartController;

/**
 * @author maxip
 */

public class Logic {

    private Game game;

    private StartController startController;

    private PutController putController;

    private MoveController moveController;

    private ContinueController continueController;

    public Logic() {
        this.game = new Game();
        this.startController = new StartController(game);
        this.putController = new PutController(game);
        this.moveController = new MoveController(game);
        this.continueController = new ContinueController(game);
    }

    public Controller getController() {
        switch (game.getState()) {
            case INITIAL:
                return startController;
            case IN_GAME:
                return game.getBoard().complete() ? moveController : putController;
            case FINAL:
                return continueController;
            case EXIT:
            default:
                return null;
        }
    }
}

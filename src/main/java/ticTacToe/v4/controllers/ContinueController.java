package ticTacToe.v4.controllers;

import ticTacToe.v4.utils.Console;
import ticTacToe.v4.models.Game;
import ticTacToe.v4.utils.State;

/**
 * @author maxip
 */
public class ContinueController extends Controller {

    public ContinueController(Game game) {
        super(game);
    }

    @Override
    public void control() {
        char answer;
        do {
            answer = Console.instance().readChar("Desea continuar? (s/n): ");
        } while (answer != 's' && answer != 'S' && answer != 'n' && answer != 'N');
        if (answer == 's' || answer == 'S') {
            this.getBoard().clear();
            this.setState(State.INITIAL);
        } else {
            this.setState(State.EXIT);
        }
    }
}

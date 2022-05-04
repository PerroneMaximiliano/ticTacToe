package ticTacToe.v3.controllers;

import ticTacToe.v3.models.*;
import ticTacToe.v3.models.Error;
import ticTacToe.v3.utils.Console;
import ticTacToe.v3.utils.State;

public abstract class CoordinateController extends Controller {

    private String actionTitle;

    private Coordinate target;

    public CoordinateController(Game game, String actionTitle) {
        super(game);
        this.target = new Coordinate();
        this.actionTitle = actionTitle;
    }

    public void control() {
        Console.instance().writeln(actionTitle + " el jugador " + getTurn().take());
        this.colocate();
        getBoard().write();
        if (getBoard().isWinner(getTurn().take())) {
            Console.instance().writeln("The winner is " + getTurn().take() + " !!!!!!!");
            this.setState(State.FINAL);
        } else {
            getTurn().change();
        }
    }

    protected abstract void colocate();

    protected void put() {
        target = new Coordinate();
        Error error;
        do {
            target.read();
            error = this.errorToPut();
            if (error != null){
                Console.instance().writeln("" + error);
            }
        } while (error != null);
        getBoard().put(getTurn().take(), target);
    }

    protected Error errorToPut() {
        if (!getBoard().isEmpty(target)) {
            return Error.NOT_EMPTY;
        }
        return null;
    }

    protected Coordinate getTarget() {
        return target;
    }
}

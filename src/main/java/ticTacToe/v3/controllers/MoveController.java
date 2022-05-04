package ticTacToe.v3.controllers;

import ticTacToe.v3.models.*;
import ticTacToe.v3.models.Error;
import ticTacToe.v3.utils.Console;

public class MoveController extends CoordinateController {

    private Coordinate origin;

    public MoveController(Game game) {
        super(game, "Mueve");
        origin = new Coordinate();
    }

    @Override
    protected void colocate() {
        this.remove();
        this.put();
    }

    private void remove() {
        Error error;
        do {
            origin.read();
            error = this.errorToRemove(origin);
            if (error != null) {
                Console.instance().writeln("" + Error.NOT_PROPERTY);
            }
        } while (error != null);
        this.getBoard().remove(origin, this.getTurn().take());
    }

    private Error errorToRemove(Coordinate origin) {
        if (!this.getBoard().full(origin, this.getTurn().take())) {
            return Error.NOT_PROPERTY;
        }
        return null;
    }

    @Override
    protected Error errorToPut() {
        Error error = super.errorToPut();
        if (error != null) {
            return error;
        }
        if (origin.equals(this.getTarget())) {
            return Error.REPEATED_COORDINATE;
        }
        return null;
    }
}

package ticTacToe.v2.controllers;

import ticTacToe.v2.models.Board;
import ticTacToe.v2.models.Coordinate;
import ticTacToe.v2.models.Turn;
import ticTacToe.v2.utils.Console;
import ticTacToe.v2.models.Error;

public class MoveController extends CoordinateController {

    private Coordinate origin;

    public MoveController(Board board, Turn turn) {
        super(board, turn);
        origin = new Coordinate();
    }

    @Override
    public void control() {
        this.control("Mueve", "A");
    }

    @Override
    protected void colocate(String targetTitle) {
        this.remove();
        this.put(targetTitle);
    }

    private void remove() {
        Error error;
        do {
            origin.read("De");
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

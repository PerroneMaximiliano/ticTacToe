package ticTacToe.v2.controllers;

import ticTacToe.v2.models.Board;
import ticTacToe.v2.models.Coordinate;
import ticTacToe.v2.models.Turn;
import ticTacToe.v2.utils.Console;
import ticTacToe.v2.models.Error;

public abstract class CoordinateController {

    private Board board;

    private Turn turn;

    private Coordinate target;

    public CoordinateController(Board board, Turn turn) {
        this.board = board;
        this.turn = turn;
        target = new Coordinate();
    }

    public abstract void control();

    protected void control(String actionTitle, String targetTitle) {
        Console.instance().writeln(actionTitle + " el jugador " + turn.take());
        this.colocate(targetTitle);
        board.write();
        if (board.isWinner(turn.take())) {
            Console.instance().writeln("The winner is " + turn.take() + " !!!!!!!");
        } else {
            turn.change();
        }
    }

    protected abstract void colocate(String targetTitle);

    protected void put(String targetTitle) {
        target = new Coordinate();
        Error error;
        do {
            target.read(targetTitle);
            error = this.errorToPut();
            if (error != null){
                Console.instance().writeln("" + error);
            }
        } while (error != null);
        board.put(turn.take(), target);
    }

    protected Error errorToPut() {
        if (!board.isEmpty(target)) {
            return Error.NOT_EMPTY;
        }
        return null;
    }

    protected Turn getTurn() {
        return turn;
    }

    protected Board getBoard() {
        return board;
    }

    protected Coordinate getTarget() {
        return target;
    }
}

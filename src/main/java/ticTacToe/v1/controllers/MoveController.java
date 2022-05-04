package ticTacToe.v1.controllers;

import ticTacToe.v1.models.Board;
import ticTacToe.v1.models.Coordinate;
import ticTacToe.v1.models.Turn;
import ticTacToe.v1.utils.Console;

import java.lang.constant.Constable;

public class MoveController {

    private Board board;

    private Turn turn;

    private Coordinate coordinate;

    public MoveController(Board board, Turn turn) {
        this.board = board;
        this.turn = turn;
        this.coordinate = new Coordinate();
    }

    public void move() {
        boolean ok;
        Console.instance().writeln("Move the player " + turn.take());
        do {
            coordinate.read();
            ok = board.full(coordinate, turn.take());
            if (!ok) {
                Console.instance().writeln("that position isn't occupied by any of your tokens");
            }
        } while (!ok);

        board.remove(coordinate, turn.take());
        Console.instance().writeln("Put the player " + turn.take());
        do {
            coordinate.read();
            ok = board.isEmpty(coordinate);
            if (!ok) {
                Console.instance().writeln("Position not empty");
            }
        } while (!ok);
        board.put(turn.take(), coordinate);
        board.write();
        if (board.isWinner()) {
            Console.instance().writeln("The winner is " + turn.take() + " !!!!!!!");
        } else {
            turn.change();
        }
    }
}

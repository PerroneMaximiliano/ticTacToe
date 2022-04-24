package ticTacToe.controllers;

import ticTacToe.models.Board;
import ticTacToe.models.Coordinate;
import ticTacToe.models.Turn;
import ticTacToe.utils.Console;

public class PutController {

    private Board board;

    private Turn turn;

    private Coordinate coordinate;

    public PutController(Board board, Turn turn) {
        this.board = board;
        this.turn = turn;
        coordinate = new Coordinate();
    }

    public void put() {
        boolean ok;
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
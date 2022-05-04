package ticTacToe.v2;

import ticTacToe.v2.controllers.MoveController;
import ticTacToe.v2.controllers.PutController;
import ticTacToe.v2.models.Board;
import ticTacToe.v2.models.Turn;

public class TicTacToe {

    private Board board;

    private Turn turn;

    private PutController putController;

    private MoveController moveController;

    private static final int NUM_PLAYERS = 2;

    public TicTacToe() {
        this.board = new Board(TicTacToe.NUM_PLAYERS);
        this.turn = new Turn();
        this.putController = new PutController(board, turn);
        this.moveController = new MoveController(board, turn);
    }

    private void play() {
        board.write();
        do {
            if (!board.complete()) {
                putController.control();
            } else {
                moveController.control();
            }
        } while(!board.isWinner());
    }

    public static void main(String[] args) {
        new TicTacToe().play();
    }
}
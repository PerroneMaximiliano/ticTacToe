package ticTacToe.v1;

import ticTacToe.v1.controllers.MoveController;
import ticTacToe.v1.controllers.PutController;
import ticTacToe.v1.models.Board;
import ticTacToe.v1.models.Turn;

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
                putController.put();
            } else {
                moveController.move();
            }
        } while(!board.isWinner());
    }

    public static void main(String[] args) {
        new TicTacToe().play();
    }
}
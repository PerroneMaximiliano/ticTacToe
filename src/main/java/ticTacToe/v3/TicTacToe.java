package ticTacToe.v3;

import ticTacToe.v3.controllers.Controller;
import ticTacToe.v3.models.Logic;

public class TicTacToe {

    private Logic logic;

    public TicTacToe() {
        logic = new Logic();
    }

    private void play() {
        Controller controller;
        do {
            controller = logic.getController();
            if (controller != null) {
                controller.control();
            }
        } while(controller != null);
    }

    public static void main(String[] args) {
        new TicTacToe().play();
    }
}
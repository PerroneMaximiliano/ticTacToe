package ticTacToe.v4.models;

public enum Color {
    XS('x'),
    OS('o'),
    NONE('_');

    private char value;

    private Color(char value){
        this.value = value;
    }

    public String toString() {
        return "" + value;
    }
}

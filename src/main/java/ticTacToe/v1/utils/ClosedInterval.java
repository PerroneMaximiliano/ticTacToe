package ticTacToe.v1.utils;

public class ClosedInterval {
    private int min;

    private int max;

    public ClosedInterval(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public boolean include(int value) {
        return min <= value && value <= max;
    }

    @Override
    public String toString() {
        return "[min=" + min + ", max=" + max + ']';
    }
}

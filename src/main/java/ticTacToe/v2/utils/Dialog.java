package ticTacToe.v2.utils;

public class Dialog {

    private String title;

    private ClosedInterval closedInterval;

    public Dialog(String title, int max) {
        this(title, 1, max);
    }

    public Dialog(String title, int min, int max) {
        this.closedInterval = new ClosedInterval(min, max);
        this.title = title + " " + closedInterval + ": ";
    }

    public int read() {
        boolean ok;
        int value;
        do {
            value = Console.instance().readInt(title);
            ok = closedInterval.include(value);
            if (!ok) {
                Console.instance().writeln("the value must be between " + closedInterval);
            }
        } while(!ok);
        return value;
    }
}

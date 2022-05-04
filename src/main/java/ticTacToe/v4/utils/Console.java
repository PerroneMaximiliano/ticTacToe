package ticTacToe.v4.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    private static Console console;

    public static Console instance() {
        if (console == null) {
            console = new Console();
        }
        return console;
    }

    private Console() {

    }

    public String readString(String string) {
        String input = null;
        boolean ok = false;
        do {
            this.write(string);
            try {
                input = bufferedReader.readLine();
                ok = true;
            } catch (Exception ex) {
                this.writeError("String");
            }
        } while (!ok);
        return input;
    }

    public int readInt(String title) {
        int input = 0;
        boolean ok = false;
        do {
            try {
                input = Integer.parseInt(this.readString(title));
                ok = true;
            } catch (Exception ex) {
                this.writeError("Integer");
            }
        } while (!ok);
        return input;
    }

    public char readChar(String title) {
        char charValue = ' ';
        boolean ok = false;
        do {
            String input = this.readString(title);
            if (input.length() != 1) {
                this.writeError("caracter");
            } else {
                charValue = input.charAt(0);
                ok = true;
            }
        } while (!ok);
        return charValue;
    }

    public void write(String string) {
        System.out.print(string);
    }

    public void writeln(String string) {
        System.out.println(string);
    }

    public void writeln() {
        System.out.println();
    }

    private void writeError(String format) {
        System.out.println("Format error, would be " + format);
    }
}

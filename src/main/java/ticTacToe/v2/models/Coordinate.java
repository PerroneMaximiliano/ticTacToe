package ticTacToe.v2.models;

import ticTacToe.v2.utils.Console;
import ticTacToe.v2.utils.Dialog;
import ticTacToe.v2.utils.Direction;
import java.util.Objects;

public class Coordinate {

    private ticTacToe.v2.utils.Coordinate coordinate;

    public static final int DIMENSION = 3;

    public Coordinate() {
        coordinate = new ticTacToe.v2.utils.Coordinate();
    }

    public Coordinate(int row, int column) {
        this();
        this.setRow(row);
        this.setColumn(column);
    }

    public Coordinate(Coordinate ticTacToeCoordinate) {
        this(ticTacToeCoordinate.coordinate.getRow(), ticTacToeCoordinate.coordinate.getColumn());
    }

    public void read(String title) {
        Console.instance().writeln(title + " qué casilla?");
        this.setRow(new Dialog("Row?", Coordinate.DIMENSION).read() - 1);
        this.setColumn(new Dialog("Column?", Coordinate.DIMENSION).read() - 1);
    }

    public Direction direction(Coordinate ticTacToeCoordinate) {
        Direction direction = coordinate.direction(ticTacToeCoordinate.coordinate);
        if (direction == Direction.INVALID) {
            if (this.inverse() && ticTacToeCoordinate.inverse()) {
                return Direction.INVERSE;
            }
        }
        return direction;
    }

    private boolean inverse() {
        return coordinate.getRow() + coordinate.getColumn() == Coordinate.DIMENSION - 1;
    }

    private void setRow(int row) {
        coordinate.setRow(row);
    }

    private void setColumn(int column) {
        coordinate.setColumn(column);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        Coordinate that = (Coordinate) o;
        return coordinate.equals(that.coordinate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate);
    }

    public Coordinate clone() {
        return new Coordinate(this);
    }
}

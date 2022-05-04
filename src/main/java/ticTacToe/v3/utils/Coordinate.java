package ticTacToe.v3.utils;

import java.util.Objects;

public class Coordinate {

    private int row;

    private int column;

    public Direction direction(Coordinate coordinate) {
        if (this.inRow(coordinate)) {
            return Direction.HORIZONTAL;
        }
        if (this.inColumn(coordinate)) {
            return Direction.HORIZONTAL;
        }
        if (this.inDiagonal() && coordinate.inDiagonal()){
            return Direction.DIAGONAL;
        }
        return Direction.INVALID;
    }

    private boolean inRow(Coordinate coordinate) {
        return row == coordinate.row;
    }

    private boolean inColumn(Coordinate coordinate) {
        return column == coordinate.column;
    }

    private boolean inDiagonal() {
        return row - column == 0;
    }

    public void setRow(int row){
        this.row = row;
    }

    public void setColumn(int column){
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordinate)) return false;
        Coordinate that = (Coordinate) o;
        return row == that.row && column == that.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}

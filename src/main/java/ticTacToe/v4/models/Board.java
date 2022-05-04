package ticTacToe.v4.models;

import ticTacToe.v4.utils.Console;
import ticTacToe.v4.utils.Direction;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Board {

    private Map<Color, Set<Coordinate>> coordinates;

    public Board(int numPlayers) {
        coordinates = new HashMap<>();
        for (int i = 0; i < numPlayers; i++) {
            coordinates.put(Color.values()[i], new HashSet<>());
        }
    }

    public void write() {
        for (int i = 0; i <= coordinates.size(); i++) {
            for (int j = 0; j <= coordinates.size(); j++) {
                Console.instance().write(getColor(new Coordinate(i, j)) + " ");
            }
            Console.instance().writeln();
        }
    }

    private Color getColor(Coordinate coordinate) {
        for (Color color : coordinates.keySet()) {
            if (coordinates.get(color).contains(coordinate)) {
                return color;
            }
        }
        return Color.NONE;
    }

    public void put(Color color, Coordinate target) {
        coordinates.get(color).add(target.clone());
    }

    public void remove(Coordinate coordinate, Color color) {
        coordinates.get(color).remove(coordinate);
    }

    public boolean isEmpty(Coordinate coordinate) {
        return !this.full(coordinate, Color.XS) && !this.full(coordinate, Color.OS);
    }

    public boolean full(Coordinate coordinate, Color color) {
        return coordinates.get(color).contains(coordinate);
    }

    public boolean complete() {
        int tokens = 0;
        for (Color color: coordinates.keySet()) {
            tokens += coordinates.get(color).size();
        }
        return tokens == Coordinate.DIMENSION * coordinates.keySet().size();
    }

    public boolean isWinner() {
        return this.isWinner(Color.OS) || this.isWinner(Color.XS);
    }

    public boolean isWinner(Color color) {
        Set<Coordinate> coordinateSet = coordinates.get(color);
        if (coordinateSet.size() != Coordinate.DIMENSION) {
            return false;
        }
        Coordinate[] coordinateArray = coordinateSet.toArray(new Coordinate[0]);
        Direction direction = coordinateArray[0].direction(coordinateArray[1]);
        if (direction == Direction.INVALID) {
            return false;
        }
        for (int i = 1; i < Coordinate.DIMENSION - 1; i++) {
            if (coordinateArray[i].direction(coordinateArray[i + 1]) != direction) {
                return false;
            }
        }
        return true;
    }

    public void clear() {
        for (Color color : coordinates.keySet()) {
            coordinates.get(color).clear();
        }
    }
}

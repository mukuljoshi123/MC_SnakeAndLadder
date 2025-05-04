package model;

import java.util.ArrayList;
import java.util.List;

public class Board {

    List<List<Cell>> cells;
    List<Snake> snakes;
    List<Ladder> ladders;

    public Board(List<Snake> snakes, List<Ladder> ladders) {
        cells = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Cell> row = new ArrayList<Cell>();
            for (int j = 0; j < 10; j++) {
                int cellNo = i * 10 + j;
                row.add(new Cell(cellNo, i, j));
            }
            cells.add(row);
        }
        this.snakes = snakes;
        this.ladders = ladders;
    }

    public int snakeBite(Cell cell) {
        return Snake.snakeBite(this.snakes, cell);
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }

    public List<Snake> getSnakes() {
        return snakes;
    }

    public void setSnakes(List<Snake> snakes) {
        this.snakes = snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public void setLadders(List<Ladder> ladders) {
        this.ladders = ladders;
    }
}

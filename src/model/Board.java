package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Board {

    List<List<Cell>> cells;
    Map<Integer,Integer> jumps;

    public Board(Map<Integer,Integer> jumps) {
        cells = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Cell> row = new ArrayList<Cell>();
            for (int j = 0; j < 10; j++) {
                int cellNo = i * 10 + j;
                row.add(new Cell(cellNo, i, j));
            }
            cells.add(row);
        }
        this.jumps = jumps;
    }

    public int getJumpCell(int cellId) {
        if(jumps.containsKey(cellId)) {
            return jumps.get(cellId);
        }else return cellId;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }

    public Map<Integer, Integer> getJumps() {
        return jumps;
    }

    public void setJumps(Map<Integer, Integer> jumps) {
        this.jumps = jumps;
    }
}

package model;

import java.util.List;

public class Snake {
    private int start;
    private int end;

    public Snake(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static int snakeBite(List<Snake> snakes, Cell cell) {
        for (Snake snake : snakes) {
            if (cell.id == snake.start) return snake.end;
        }
        return cell.id;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}

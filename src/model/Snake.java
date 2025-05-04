package model;

import java.util.List;

public class Snake {
    private int start;
    private int end;

    public Snake(int start, int end) {
        if (start < end) {
            throw new IllegalArgumentException("start must be greater than end");
        }
        this.start = start;
        this.end = end;
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

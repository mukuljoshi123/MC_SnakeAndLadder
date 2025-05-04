package model;

public class Cell {

    int id;
    int i;
    int j;

    public Cell(int id, int i, int j) {
        this.id = id;
        this.i = i;
        this.j = j;
    }

    public Cell(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}

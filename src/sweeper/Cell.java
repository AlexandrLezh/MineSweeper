package sweeper;

public class Cell {
    public int x;
    public int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Cell))
            return super.equals(obj);
        Cell toCell = (Cell) obj;
        return toCell.x == x && toCell.y == y;
    }
}

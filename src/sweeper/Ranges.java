package sweeper;

import java.util.ArrayList;
import java.util.Random;

public class Ranges {
    private static Cell size;
    private static ArrayList<Cell> allCell;
    private static final Random random = new Random();

    public static Cell getSize(){
        return size;
    }

    public static ArrayList<Cell> getAllCells() {
        return allCell;
    }

    static void setSize(Cell size) {
        Ranges.size = size;
        allCell = new ArrayList<>();
        for (int x = 0; x < size.x; x++) {
            for (int y = 0; y < size.y; y++) {
                allCell.add(new Cell(x, y));
            }
        }
    }

    static boolean inRange(Cell cell) {
        return cell.x >= 0 && cell.x < Ranges.size.x &&
               cell.y >= 0 && cell.y < Ranges.size.y;
    }

    static Cell getRandomCell() {
        return new Cell(random.nextInt(size.x), random.nextInt(size.y));
    }

    static ArrayList<Cell> getCellsAround(Cell cell) {
        ArrayList<Cell> list = new ArrayList<>();
        for (int x = cell.x - 1; x <= cell.x + 1; x++) {
            for (int y = cell.y - 1; y <= cell.y + 1; y++) {
                Cell around = new Cell(x, y);
                if (inRange(around)) {
                    if (!around.equals(cell)) {
                        list.add(around);
                    }
                }
            }
        }
        return list;
    }

    static int getSquare() {
        return size.x * size.y;
    }
}

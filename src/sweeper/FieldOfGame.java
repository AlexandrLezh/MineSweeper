package sweeper;

import java.util.ArrayList;
import java.util.Random;

public class FieldOfGame {
    private static Cell size;
    private static ArrayList<Cell> allCell;
    private static final Random random = new Random();

    public static Cell getSize(){
        return size;
    }

    public static ArrayList<Cell> getAllCells() {
        return allCell;
    }

    static void setSize(Cell lastCell) {
        FieldOfGame.size = lastCell;
        allCell = new ArrayList<>();
        for (int i = 0; i < lastCell.x; i++) {
            for (int j = 0; j < lastCell.y; j++) {
                allCell.add(new Cell(i, j));
            }
        }
    }

    static boolean inRange(Cell cell) {
        return cell.x >= 0 && cell.x < FieldOfGame.size.x &&
               cell.y >= 0 && cell.y < FieldOfGame.size.y;
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

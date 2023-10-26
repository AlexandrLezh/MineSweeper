package sweeper;

import java.util.ArrayList;
import java.util.Random;

public class Ranges {
    private static Coord size;
    private static ArrayList<Coord> allCoord;
    private static Random random;

    static void setSize(Coord size) {
        Ranges.size = size;
    }
    public static void setSize(int cols, int rows) {
        Coord size = new Coord(cols, rows);
        setSize(size);
    }

    public static Coord getSize(){
        return size;
    }
}

package sweeper;

import java.util.ArrayList;
import java.util.Random;

public class Ranges {
    private static Coord size;
    private static ArrayList<Coord> allCoord;
    private static Random random;

    static void setSize(Coord size) {
        Ranges.size = size;
        allCoord = new ArrayList<Coord>();
        for (int x = 0; x < size.x; x++) {
            for (int y = 0; y < size.y; y++) {
                allCoord.add(new Coord(x, y));
            }
        }
    }

    public static Coord getSize(){
        return size;
    }

    public static ArrayList<Coord> getAllCoord() {
        return allCoord;
    }
}

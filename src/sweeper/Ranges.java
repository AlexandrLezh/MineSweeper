package sweeper;

import java.util.ArrayList;
import java.util.Random;

public class Ranges {
    private static Coord size;
    private static ArrayList<Coord> allCoord;
    private static Random random = new Random();

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

    public static boolean inRange(Coord coord) {
        return coord.x >= 0 && coord.x < size.x &&
               coord.y >= 0 && coord.y < size.y;
    }

    static Coord getRandomCoord() {
        return new Coord(random.nextInt(size.x), random.nextInt(size.y));
    }
}

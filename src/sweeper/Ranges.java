package sweeper;

import java.util.ArrayList;
import java.util.Random;

public class Ranges {
    private static Coord size;
    private static ArrayList<Coord> allCoord;
    private static final Random random = new Random();

    static void setSize(Coord size) {
        Ranges.size = size;
        allCoord = new ArrayList<>();
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

    static boolean inRange(Coord coord) {
        return coord.x >= 0 && coord.x < size.x &&
               coord.y >= 0 && coord.y < size.y;
    }

    static Coord getRandomCoord() {
        return new Coord(random.nextInt(size.x), random.nextInt(size.y));
    }

    static ArrayList<Coord> getCoordsArround(Coord coord) {
        ArrayList<Coord> list = new ArrayList<>();
        for (int x = coord.x - 1; x <= coord.x + 1; x++) {
            for (int y = coord.y - 1; y <= coord.y + 1; y++) {
                Coord around = new Coord(x, y);
                if (inRange(around)) {
                    if (!around.equals(coord)) {
                        list.add(around);
                    }
                }
            }
        }
        return list;
    }
}

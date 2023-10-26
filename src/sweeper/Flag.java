package sweeper;

class Flag {
    private Matrix flagMap;
    private int totalFlags;
    private int countOfClosedBoxes;

    void start() {
        flagMap = new Matrix(Box.CLOSED);
        Coord coord = new Coord(4, 4);
        for (Coord around : Ranges.getCoordsArround(coord)) {
            flagMap.set(around, Box.OPENED);
        }

    }

    Box get(Coord coord) {
        return flagMap.get(coord);
    }
}

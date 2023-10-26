package sweeper;

class Flag {
    private Matrix flagMap;
    private int totalFlags;
    private int countOfClosedBoxes;

    void start() {
        flagMap = new Matrix(Box.CLOSED);

    }

    Box get(Coord coord) {
        return flagMap.get(coord);
    }

    void setOpenedToBox(Coord coord) {
        flagMap.set(coord, Box.OPENED);
    }

    private void setFlaggedToBox(Coord coord) {
        flagMap.set(coord, Box.FLAGGED);
    }

    private void setClosedToBox(Coord coord) {
        flagMap.set(coord, Box.CLOSED);
    }
    void toggleFlaggedToBox(Coord coord) {
        switch (flagMap.get(coord)) {
            case FLAGGED -> setClosedToBox(coord);
            case CLOSED -> setFlaggedToBox(coord);
        }
    }




}

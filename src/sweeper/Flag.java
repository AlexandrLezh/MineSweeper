package sweeper;

class Flag {
    private Matrix flagMap;



    private int totalFlagged;
    private int totalClosed;

    void start() {
        flagMap = new Matrix(Box.CLOSED);
        totalFlagged = 0;
        totalClosed = Ranges.getSquare();
    }

    int getTotalFlagged() {
        return totalFlagged;
    }

    int getTotalClosed() {
        return totalClosed;
    }
    Box get(Coord coord) {
        return flagMap.get(coord);
    }

    void setOpenedToBox(Coord coord) {
        flagMap.set(coord, Box.OPENED);
    }

    private void setFlaggedToBox(Coord coord) {
        flagMap.set(coord, Box.FLAGGED);
        totalFlagged++; //todo move to setter
    }

    private void setClosedToBox(Coord coord) {
        flagMap.set(coord, Box.CLOSED);
        totalFlagged--; //todo move to setter
    }
    void toggleFlaggedToBox(Coord coord) {
        switch (flagMap.get(coord)) {
            case FLAGGED -> setClosedToBox(coord);
            case CLOSED -> setFlaggedToBox(coord);
        }
    }




}

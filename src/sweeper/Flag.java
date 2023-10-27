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
    Box get(Cell cell) {
        return flagMap.get(cell);
    }

    void setOpenedToBox(Cell cell) {
        flagMap.set(cell, Box.OPENED);
    }

    private void setFlaggedToBox(Cell cell) {
        flagMap.set(cell, Box.FLAGGED);
        totalFlagged++; //todo move to setter
    }

    private void setClosedToBox(Cell cell) {
        flagMap.set(cell, Box.CLOSED);
        totalFlagged--; //todo move to setter
    }
    void toggleFlaggedToBox(Cell cell) {
        switch (flagMap.get(cell)) {
            case FLAGGED -> setClosedToBox(cell);
            case CLOSED -> setFlaggedToBox(cell);
        }
    }




}

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
        totalClosed--;
    }

    private void setFlaggedToBox(Cell cell) {
        flagMap.set(cell, Box.FLAGGED);
        totalFlagged++;
    }

    private void setClosedToBox(Cell cell) {
        flagMap.set(cell, Box.CLOSED);
        totalFlagged--;
    }
    void toggleFlaggedToBox(Cell cell) {
        switch (flagMap.get(cell)) {
            case FLAGGED -> setClosedToBox(cell);
            case CLOSED -> setFlaggedToBox(cell);
        }
    }


    public void setFlaggedToLastClosedBoxes() {
        for (Cell cell : Ranges.getAllCells()) {
            if (Box.CLOSED == flagMap.get(cell)) {
                setFlaggedToBox(cell);
            }
        }
    }

    public void setBombedToBox(Cell cell) {
        flagMap.set(cell, Box.BOMBED);
    }

    public void setOpenedToClosedBox(Cell cell) {
        if (Box.CLOSED == flagMap.get(cell)) {
            flagMap.set(cell, Box.OPENED);
        }
    }

    public void setNoBombToFlaggedBox(Cell cell) {
        if (Box.FLAGGED == flagMap.get(cell)) {
            flagMap.set(cell, Box.NOBOMB);
        }
    }

    int getCountOfFlaggedBoxesAround(Cell cell) {
        int countFlags = 0;
        for (Cell around : Ranges.getCellsAround(cell)) {
            if (flagMap.get(around) == Box.FLAGGED) {
                countFlags++;
            }
        }
        return countFlags;
    }
}

package sweeper;

class Bomb {
    private Matrix bombMap;
    private int totalBombs;

    Bomb(int totalBombs) {
        this.totalBombs = totalBombs;
        fixBombsCount();
    }

    void start() {
        bombMap = new Matrix(Box.ZERO);
        for (int i = 0; i < totalBombs; i++) {
            placeBomb();
        }
    }

    Box get(Cell cell) {
        return bombMap.get(cell);
    }

    private void placeBomb() {
        while (true) {
            Cell cell = Ranges.getRandomCell();
            if (Box.BOMB == bombMap.get(cell)) {
                continue;
            }
            bombMap.set(cell, Box.BOMB);
            incNumbersAroundBomb(cell);
            break;
        }
    }

    private void incNumbersAroundBomb(Cell cell) {
        for (Cell around : Ranges.getCellsAround(cell)){
            if (Box.BOMB != bombMap.get(around)) {
                bombMap.set(around, bombMap.get(around).nextNumberBox());
            }
        }
    }

    private void fixBombsCount() {
        int maxBombs = Ranges.getCell().x * Ranges.getCell().y / 2;
        if (totalBombs > maxBombs) {
            totalBombs = maxBombs;
        }
    }

    int getTotalBombs() {
        return totalBombs;
    }

}

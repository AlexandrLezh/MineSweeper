package sweeper;

class BottomBombLayer {
    private Matrix bombMap;
    private int totalBombs;

    BottomBombLayer(int totalBombs) {
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
            Cell cell = FieldOfGame.getRandomCell();
            if (Box.BOMB == bombMap.get(cell)) {
                continue;
            }
            bombMap.set(cell, Box.BOMB);
            incNumbersAroundBomb(cell);
            break;
        }
    }

    private void incNumbersAroundBomb(Cell cell) {
        for (Cell around : FieldOfGame.getCellsAround(cell)){
            if (Box.BOMB != bombMap.get(around)) {
                bombMap.set(around, bombMap.get(around).nextNumberBox());
            }
        }
    }

    private void fixBombsCount() {
        int maxBombs = FieldOfGame.getSize().x * FieldOfGame.getSize().y / 2;
        if (totalBombs > maxBombs) {
            totalBombs = maxBombs;
        }
    }

    int getTotalBombs() {
        return totalBombs;
    }

}

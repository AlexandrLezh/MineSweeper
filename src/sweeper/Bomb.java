package sweeper;

class Bomb {
    private Matrix bombMap;
    private int totalBomb;

    Bomb(int totalBomb) {
        this.totalBomb = totalBomb;
    }

    void start() {
        bombMap = new Matrix(Box.ZERO);
        for (int i = 0; i < totalBomb; i++) {
            placeBomb();
        }
    }

    Box get(Coord coord) {
        return bombMap.get(coord);
    }

    void placeBomb() {
        bombMap.set(Ranges.getRandomCoord(), Box.BOMB);

    }
}

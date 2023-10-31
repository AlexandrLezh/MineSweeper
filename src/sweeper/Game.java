package sweeper;

public class Game {
    private final BottomBombLayer bottomBombLayer;
    private final TopFlagLayer topFlagLayer;
    private GameState state;

    public Game(int cols, int rows, int bombs) {
        FieldOfGame.setSize(new Cell(cols, rows));
        bottomBombLayer = new BottomBombLayer(bombs);
        topFlagLayer = new TopFlagLayer();

    }

    public void start() {
       bottomBombLayer.start();
       topFlagLayer.start();
       state = GameState.PLAYED;
    }
    public Box getBox(Cell cell) {
        if (Box.OPENED == topFlagLayer.get(cell)) {
            return bottomBombLayer.get(cell);
        } else {
            return topFlagLayer.get(cell);
        }
    }

    private void checkWinner() {
        if (GameState.PLAYED == state) {
            if (topFlagLayer.getTotalClosed() == bottomBombLayer.getTotalBombs()) {
                state = GameState.WINNER;
                topFlagLayer.setFlaggedToLastClosedBoxes();
            }
        }
    }

    public void pressLeftButton(Cell cell) {
        if (isGameOver()) {
            return;
        }
        openBox(cell);
        checkWinner();
    }

    public void pressRightButton(Cell cell) {
        if (isGameOver()) {
            return;
        }
        topFlagLayer.toggleFlaggedToBox(cell);
    }

    private boolean isGameOver() {
        if (GameState.PLAYED != state) {
            start();
            return true;
        }
        return false;
    }

    public int getTotalBombs() {
        return bottomBombLayer.getTotalBombs();
    }

    public int getTotalFlaged() {
        return topFlagLayer.getTotalFlagged();
    }

    public GameState getState() {
        return state;
    }

    private void openBox(Cell cell) {
        switch(topFlagLayer.get(cell)) {
            case OPENED -> setOpenedToClosedBoxesAroundNumber(cell);
            case CLOSED -> getBottomLayer(cell);
            case FLAGGED -> {}
        }
    }

    private void getBottomLayer(Cell cell) {
        switch (bottomBombLayer.get(cell)) {
            case ZERO -> openBoxesAroundZero(cell);
            case BOMB -> openBombs(cell);
            default -> topFlagLayer.setOpenedToBox(cell);
        }
    }

    private void setOpenedToClosedBoxesAroundNumber(Cell cell) {
        if (Box.BOMB != bottomBombLayer.get(cell)) {
            if (bottomBombLayer.get(cell).getNumber() == topFlagLayer.getCountOfFlaggedBoxesAround(cell)) {
                for (Cell around : FieldOfGame.getCellsAround(cell)) {
                    if (Box.CLOSED == topFlagLayer.get(around)) {
                        openBox(around);
                    }
                }
            }
        }
    }

    private void openBombs(Cell bombedCell) {
        topFlagLayer.setBombedToBox(bombedCell);
        for (Cell cell : FieldOfGame.getAllCells()) {
            if (bottomBombLayer.get(cell) == Box.BOMB) {
                topFlagLayer.setOpenedToClosedBox(cell);
            } else {
                topFlagLayer.setNoBombToFlaggedBox(cell);
            }
        }
        state = GameState.BOMBED;
    }

    private void openBoxesAroundZero(Cell cell) {
        topFlagLayer.setOpenedToBox(cell);
        for (Cell around : FieldOfGame.getCellsAround(cell)) {
            openBox(around);
        }
    }
}

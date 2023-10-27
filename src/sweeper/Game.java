package sweeper;

public class Game {
    private final Bomb bomb;
    private final Flag flag;



    private GameState state;

    public Game(int cols, int rows, int bombs) {
        Ranges.setSize(new Cell(cols, rows));
        bomb = new Bomb(bombs);
        flag = new Flag();

    }

    public void start() {
       bomb.start();
       flag.start();
       state = GameState.PLAYED;
    }
    public Box getBox(Cell cell) {
        if (Box.OPENED == flag.get(cell)) {
            return bomb.get(cell);
        } else {
            return flag.get(cell);
        }
    }

    public void pressLeftButton(Cell cell) {
        openBox(cell);

    }

    public void pressRightButton(Cell cell) {
        flag.toggleFlaggedToBox(cell);
    }

    public int getTotalBombs() {
        return bomb.getTotalBombs();
    }

    public int getTotalFlaged() {
        return flag.getTotalFlagged();
    }
    public GameState getState() {
        return state;
    }

    private void openBox(Cell cell) {
        switch(flag.get(cell)) {
            case OPENED : break;
            case FLAGGED : break;
            case CLOSED :
                switch (bomb.get(cell)) {
                    case ZERO : openBoxesAroundZero(cell); break;
                    case BOMB : break;
                    default : flag.setOpenedToBox(cell); break;
                }
        }
    }

    private void openBoxesAroundZero(Cell cell) {
        flag.setOpenedToBox(cell);
        for (Cell around : Ranges.getCoordsArround(cell)) {
            openBox(around);
        }
    }
}

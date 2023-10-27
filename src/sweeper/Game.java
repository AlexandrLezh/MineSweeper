package sweeper;

public class Game {
    private final Bomb bomb;
    private final Flag flag;



    private GameState state;

    public Game(int cols, int rows, int bombs) {
        Ranges.setSize(new Coord(cols, rows));
        bomb = new Bomb(bombs);
        flag = new Flag();

    }

    public void start() {
       bomb.start();
       flag.start();
       state = GameState.PLAYED;
    }
    public Box getBox(Coord coord) {
        if (Box.OPENED == flag.get(coord)) {
            return bomb.get(coord);
        } else {
            return flag.get(coord);
        }
    }

    public void pressLeftButton(Coord coord) {
        flag.setOpenedToBox(coord);
        state = GameState.BOMBED;

    }

    public void pressRightButton(Coord coord) {
        flag.toggleFlaggedToBox(coord);
        state = GameState.WINNER;
    }

    public GameState getState() {
        return state;
    }
}

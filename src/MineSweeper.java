import javax.swing.*;
import java.awt.*;
import sweeper.Box;
import sweeper.Coord;
import sweeper.Game;
import sweeper.Ranges;

public class MineSweeper extends JFrame {

    private final int IMAGE_SIZE = 50;
    private final int COLS = 9;
    private final int ROWS = 9;
    private final int BOMBS = 10;
    private JPanel panel;
    private Game game;
    public static void main(String[] args) {
        new MineSweeper().setVisible(true);
    }

    private MineSweeper() {
        game = new Game(COLS, ROWS, BOMBS);
        game.start();
        setImages();
        initPanel();
        initFrame();
    }

    private void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Coord coord : Ranges.getAllCoord()) {
                    g.drawImage((Image) game.getBox(coord).image,
                            coord.x * IMAGE_SIZE,
                            coord.y * IMAGE_SIZE, this);
                }
            }
        };
        game.pressLeftButton(new Coord(4, 4));
        game.pressRightButton(new Coord(7, 7));
        setUpPanelSize();
    }

    private void setUpPanelSize() {
        int widthPanel = Ranges.getSize().x * IMAGE_SIZE;
        int heightPanel = Ranges.getSize().y * IMAGE_SIZE;

        Dimension panelSize = new Dimension(widthPanel, heightPanel);

        panel.setPreferredSize(panelSize);
        add(panel);
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mine Sweeper");
        setResizable(false);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void setImages() {
        for(Box box : Box.values()) {
            box.image = getImage(box.name().toLowerCase());
        }
    }
    private Image getImage(String name) {
        String fileName = "img/" + name + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(fileName));
        return icon.getImage();
    }

}

import sweeper.Box;
import sweeper.Cell;
import sweeper.Game;
import sweeper.Ranges;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MineSweeper extends JFrame {

    private final int IMAGE_SIZE = 50;
    private final int COLS = 9;
    private final int ROWS = 9;
    private final int BOMBS = 10;
    private JPanel panel;
    private JLabel label;
    private final Game game;
    public static void main(String[] args) {
        new MineSweeper().setVisible(true);
    }

    private MineSweeper() {
        game = new Game(COLS, ROWS, BOMBS);
        game.start();
        setImages();
        initPanel();
        initLabel();
        initFrame();
    }

    private  void initLabel() {
        Font font = new Font("Tahoma", Font.BOLD, 18);
        label = new JLabel(getMessage());
        label.setFont(font);
        add (label, BorderLayout.SOUTH);
    }
    private void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Cell cell : Ranges.getAllCoord()) {
                    g.drawImage((Image) game.getBox(cell).image,
                            cell.x * IMAGE_SIZE,
                            cell.y * IMAGE_SIZE, this);
                }
            }
        };
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / IMAGE_SIZE;
                int y = e.getY() / IMAGE_SIZE;
                Cell cell = new Cell(x, y);
                switch (e.getButton()) {
                    case MouseEvent.BUTTON1 -> game.pressLeftButton(cell);
                    case MouseEvent.BUTTON3 -> game.pressRightButton(cell);
                    case MouseEvent.BUTTON2 -> game.start();
                }
                label.setText(getMessage());
                panel.repaint();
            }
        });
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

    private String getMessage() {
        switch (game.getState()) {
            case WINNER:
                return "Congratulation ! All bombs marked";
            case BOMBED:
                return "BOOM ! You Lose !";
            case PLAYED:
            default:
                if (game.getTotalFlaged() == 0) {
                    return "Welcome !";
                } else {
                    return "Think twice ! Flagged " +
                            game.getTotalFlaged() + " of " +
                            game.getTotalBombs() + " bombs.";
                }

        }
    }

}

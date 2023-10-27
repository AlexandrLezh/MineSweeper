import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
    private JLabel label;
    private Game game;
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
                for (Coord coord : Ranges.getAllCoord()) {
                    g.drawImage((Image) game.getBox(coord).image,
                            coord.x * IMAGE_SIZE,
                            coord.y * IMAGE_SIZE, this);
                }
            }
        };
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX() / IMAGE_SIZE;
                int y = e.getY() / IMAGE_SIZE;
                Coord coord = new Coord(x, y);
                switch (e.getButton()) {
                    case MouseEvent.BUTTON1 -> game.pressLeftButton(coord);
                    case MouseEvent.BUTTON3 -> game.pressRightButton(coord);
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
            case WINNER : return "Congratulation ! All bombs marked";
            case BOMBED: return "You Lose !";
            case PLAYED :
            default: return "Welcome !";
        }
    }

}

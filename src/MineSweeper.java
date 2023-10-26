import javax.swing.*;
import java.awt.*;
import sweeper.Box;

public class MineSweeper extends JFrame {

    private final int IMAGE_SIZE = 50;
    private final int COLS = 15;
    private final int ROWS = 10;
    private JPanel panel;

    public static void main(String[] args) {
        new MineSweeper().setVisible(true);
    }

    private MineSweeper() {
        setImages();
        initPanel();
        initFrame();
    }

    private void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Box box : Box.values()) {
                    g.drawImage(box.image, box.ordinal() * IMAGE_SIZE, 0, this);
                }
            }
        };
        setUpPanelSize();
    }

    private void setUpPanelSize() {
        int widthPanel = COLS * IMAGE_SIZE;
        int heightPanel = ROWS * IMAGE_SIZE;

        Dimension panelSize = new Dimension(widthPanel, heightPanel);

        panel.setPreferredSize(panelSize);
        add(panel);
    }

    private void initFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mine Sweeper");
        setVisible(true);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }

    private void setImages() {
        for(Box box : Box.values()) {
            box.image = getImage(box.name().toLowerCase());
        }
    }
    private Image getImage(String name) {
        ImageIcon icon = new ImageIcon("res/img/" + name + ".png");
        return icon.getImage();
    }

}

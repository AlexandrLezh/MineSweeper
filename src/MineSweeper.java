import javax.swing.*;
import java.awt.*;

public class MineSweeper extends JFrame {

    private final int IMAGE_SIZE = 50;
    private final int COLS = 15;
    private final int ROWS = 10;
    private JPanel panel;

    public static void main(String[] args) {
        new MineSweeper().setVisible(true);
    }

    private MineSweeper() {
        initPanel();
        initFrame();
    }

    private void initPanel() {
        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(getImage("bomb"), 0, 0, this);
                g.drawImage(getImage("num1"), IMAGE_SIZE, 0, this);
                g.drawImage(getImage("num1"), IMAGE_SIZE, IMAGE_SIZE, this);
                g.drawImage(getImage("num1"), 0, IMAGE_SIZE, this);
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

    private Image getImage(String name) {
        ImageIcon icon = new ImageIcon("res/img/" + name + ".png");
        return icon.getImage();
    }

}

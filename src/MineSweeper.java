import javax.swing.*;
import java.awt.*;

public class MineSweeper extends JFrame {

    JPanel panel;

    public static void main(String[] args) {
        new MineSweeper().setVisible(true);
    }

    public MineSweeper() {
        panel= new JPanel();
        panel.setPreferredSize(new Dimension(500, 300));
        add(panel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mine Sweeper");
        setVisible(true);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }
}

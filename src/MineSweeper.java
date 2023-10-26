import javax.swing.*;

public class MineSweeper extends JFrame {
    public static void main(String[] args) {
        new MineSweeper().setVisible(true);
    }

    public MineSweeper() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mine Sweeper");
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

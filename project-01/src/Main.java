import java.awt.BorderLayout;
import javax.swing.JFrame;

public class Main extends JFrame {

    private final GamePanel contentPane;

    public Main() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 900);
        setLocationRelativeTo(null);
        contentPane = new GamePanel();
        add(contentPane, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}

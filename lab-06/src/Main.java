import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class Main extends JFrame {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    public static CPanel cPanel;

    public Main() {
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cPanel = new CPanel();
        cPanel.setFocusable(true);
        cPanel.requestFocus();
        cPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP -> cPanel.up();
                    case KeyEvent.VK_DOWN -> cPanel.down();
                    case KeyEvent.VK_LEFT -> cPanel.left();
                    case KeyEvent.VK_RIGHT -> cPanel.right();
                }
                repaint();
            }
        });
        add(cPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}

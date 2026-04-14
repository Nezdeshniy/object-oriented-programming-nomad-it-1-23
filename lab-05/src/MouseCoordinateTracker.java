import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseCoordinateTracker {

    public static void main(String[] args) {
        JFrame frame = new JFrame("MouseCoordinateTracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setBackground(Color.BLUE);
        frame.setLayout(new GridLayout(1, 2));

        JPanel leftPanel = new DrawPanel();
        leftPanel.setBackground(Color.GRAY);

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.YELLOW);
        JButton button = new JButton("Click Me");
        button.addActionListener(e -> { });
        rightPanel.add(button);

        frame.add(leftPanel);
        frame.add(rightPanel);
        frame.setVisible(true);
    }
}

class DrawPanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 200, 50);
        g.setColor(Color.BLACK);
        g.fillOval(300, 0, 200, 100);
    }
}

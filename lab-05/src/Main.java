import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Color Picker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JButton button1 = new JButton("Press1");
        JButton button2 = new JButton("Press2");

        JPanel panel = new ColorPanel();
        panel.add(button1);
        panel.add(button2);

        button1.addActionListener(e -> {
            ColorPanel.colorIndex.set(1);
            panel.repaint();
        });
        button2.addActionListener(e -> {
            ColorPanel.colorIndex.set(2);
            panel.repaint();
        });

        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}

class ColorPanel extends JPanel {
    Color[] colors = {Color.RED, Color.BLUE, Color.GREEN};
    static AtomicInteger colorIndex = new AtomicInteger();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(colors[colorIndex.get()]);
        g.fillOval(100, 100, 200, 200);
    }
}

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Problem01 extends JFrame {

    JPanel colorPanel = new JPanel();
    JPanel controlPanel = new JPanel();

    JButton redButton = new JButton("RED");
    JButton greenButton = new JButton("GREEN");
    JButton blueButton = new JButton("BLUE");

    public Problem01() {
        setTitle("Problem 01");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        colorPanel.setBackground(Color.RED);
        add(colorPanel, BorderLayout.CENTER);
        controlPanel.setBackground(Color.GRAY);
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        controlPanel.add(redButton);
        controlPanel.add(greenButton);
        controlPanel.add(blueButton);
        add(controlPanel, BorderLayout.SOUTH);

        redButton.addActionListener(new ColorListener(colorPanel, Color.RED));
        blueButton.addActionListener(new ColorListener(colorPanel, Color.BLUE));
        greenButton.addActionListener(new ColorListener(colorPanel, Color.GREEN));
    }

    public static void main(String[] args) {
        new Problem01().setVisible(true);
    }
}

class ColorListener implements ActionListener {
    private final JPanel panel;
    private final Color color;

    public ColorListener(JPanel panel, Color color) {
        this.panel = panel;
        this.color = color;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        panel.setBackground(color);
    }
}

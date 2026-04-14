import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TemperatureConverter {

    static int temperature = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Temperature Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 1));
        JPanel panel2 = new JPanel();

        JTextField textField = new JTextField(10);
        JLabel celsiusLabel = new JLabel("Temperature: " + temperature + "C");
        JLabel fahrenheitLabel = new JLabel("Fahrenheit: ");

        panel.add(celsiusLabel);
        panel.add(textField);
        panel.add(fahrenheitLabel);

        JButton button = new JButton("Convert");
        panel2.add(button);

        button.addActionListener(e -> {
            temperature = Integer.parseInt(textField.getText());
            celsiusLabel.setText("Temperature: " + temperature + "C");
            double converted = (double) (temperature * 9) / 5 + 32;
            fahrenheitLabel.setText("Fahrenheit: " + String.format("%.2f", converted) + "F");
        });

        frame.add(panel, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}

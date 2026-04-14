import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class CPanel extends JPanel {

    private int ovalX;
    private int ovalY;
    private final int cellWidth;
    private final int cellHeight;

    public CPanel() {
        setBackground(Color.GRAY);
        ovalX = 0;
        ovalY = 0;
        cellWidth = Main.WIDTH / 8;
        cellHeight = Main.HEIGHT / 8;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int col = 0; col < 8; col++) {
            for (int row = 0; row < 8; row++) {
                int x1 = col * cellWidth;
                int y1 = row * cellHeight;
                boolean isLight = (col + row) % 2 == 0;
                g.setColor(isLight ? Color.BLACK : Color.WHITE);
                g.fillRect(x1, y1, cellWidth, cellHeight);
            }
        }

        g.setColor(Color.RED);
        g.fillOval(ovalX, ovalY, cellWidth, cellHeight);
    }

    public void up() { ovalY -= cellHeight; }
    public void down() { ovalY += cellHeight; }
    public void left() { ovalX -= cellWidth; }
    public void right() { ovalX += cellWidth; }
}

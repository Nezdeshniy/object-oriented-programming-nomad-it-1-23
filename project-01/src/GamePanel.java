import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 900;
    private final GameBoard gameBoard;

    public GamePanel() {
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        gameBoard = new GameBoard();
        setFocusable(true);
        addKeyListener(new CustomKeyAdapter(gameBoard, this));
    }

    @Override
    public synchronized void addKeyListener(KeyListener l) {
        super.addKeyListener(l);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("Arial", Font.BOLD, 36));
        g.setColor(Color.BLACK);
        g.drawString("2048", (SCREEN_WIDTH / 2) - 40, 40);
        int cw = 200; int ch = 200;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                renderTile(g, j * cw, i * ch + 50, gameBoard.board[i][j]);
            }
        }
    }

    private void renderTile(Graphics gu, int x, int y, Tile tile) {
        Graphics2D g = (Graphics2D) gu;
        if (tile == null) return;
        g.setFont(new Font("Arial", Font.BOLD, 36));
        g.setStroke(new BasicStroke(10f));
        g.setColor(tile.getColor());
        g.fillRect(x + 10, y + 10, 190, 190);
        g.setColor(Color.GRAY);
        g.drawRect(x, y, 200, 200);
        if (tile.getValue() != 1) {
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(tile.getValue()), x + 100, y + 100);
        }
    }
}

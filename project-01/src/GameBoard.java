import java.awt.Color;
import java.util.Random;

public class GameBoard {

    public static final int BOARD_COLUMNS = 4;
    public static final int BOARD_ROWS = 4;
    public Tile[][] board = new Tile[BOARD_ROWS][BOARD_COLUMNS];
    public int[] powers = new int[10];
    public Color[] colors = new Color[10];

    public GameBoard() {
        initPowers();
        int startVal = randomValue();
        board[randomRow()][randomColumn()] = new Tile(startVal, colors[startVal], Color.BLACK);
        for (int i = 0; i < BOARD_ROWS; i++) {
            for (int j = 0; j < BOARD_COLUMNS; j++) {
                if (board[i][j] == null) board[i][j] = new Tile(1, colors[1], Color.BLACK);
            }
        }
    }

    public int randomColumn() { return new Random().nextInt(BOARD_COLUMNS); }
    public int randomRow() { return new Random().nextInt(BOARD_ROWS); }
    public int randomValue() { return Math.random() < 0.9 ? 2 : 4; }

    public void initPowers() {
        for (int i = 1; i < powers.length; i++) {
            powers[i] = (int) Math.pow(2, i);
            colors[i] = getTileColor(powers[i]);
        }
    }

    private Color getTileColor(int value) {
        Color start = new Color(255, 255, 255);
        Color end = new Color(255, 100, 0);
        int maxPower = 11;
        int cp = (int) Math.log(value);
        float t = (float) cp / maxPower;
        int r = (int) (start.getRed() + t * (end.getRed() - start.getRed()));
        int g = (int) (start.getGreen() + t * (end.getGreen() - start.getGreen()));
        int b = (int) (start.getBlue() + t * (end.getBlue() - start.getBlue()));
        return new Color(r, g, b);
    }

    public void right() { slideRight(); mergeRight(); slideRight(); spawnRandom(); printBoard(); }
    public void left() { slideLeft(); mergeLeft(); slideLeft(); spawnRandom(); printBoard(); }

    private void slideRight() {
        for (int i = 0; i < BOARD_ROWS; i++) {
            for (int j = BOARD_COLUMNS - 1; j >= 0; j--) {
                Tile tile = board[i][j]; int target = j;
                for (int k = j + 1; k < BOARD_COLUMNS; k++) { if (board[i][k].getValue() == 1) target++; else break; }
                if (target != j) { board[i][j] = new Tile(1, colors[1], Color.BLACK); board[i][target] = tile; }
            }
        }
    }

    private void mergeRight() {
        for (int i = 0; i < BOARD_ROWS; i++) {
            for (int j = 0; j < BOARD_COLUMNS - 1; j++) {
                Tile a = board[i][j]; Tile b = board[i][j + 1];
                if (a.getValue() == b.getValue() && b.getValue() != 1) {
                    board[i][j + 1] = new Tile(1, colors[1], Color.BLACK);
                    int merged = a.getValue() + b.getValue();
                    board[i][j] = new Tile(merged, getTileColor(merged), Color.BLACK);
                }
            }
        }
    }

    private void slideLeft() {
        for (int i = 0; i < BOARD_ROWS; i++) {
            for (int j = 0; j < BOARD_COLUMNS; j++) {
                Tile tile = board[i][j]; int target = j;
                for (int k = j - 1; k >= 0; k--) { if (board[i][k].getValue() == 1) target--; else break; }
                if (target != j) { board[i][j] = new Tile(1, colors[1], Color.BLACK); board[i][target] = tile; }
            }
        }
    }

    private void mergeLeft() {
        for (int i = 0; i < BOARD_ROWS; i++) {
            for (int j = 0; j < BOARD_COLUMNS - 1; j++) {
                Tile a = board[i][j]; Tile b = board[i][j + 1];
                if (a.getValue() == b.getValue() && b.getValue() != 1) {
                    board[i][j + 1] = new Tile(1, colors[1], Color.BLACK);
                    int merged = a.getValue() + b.getValue();
                    board[i][j] = new Tile(merged, getTileColor(merged), Color.BLACK);
                }
            }
        }
    }

    private void spawnRandom() {
        while (true) {
            int i = randomRow(); int j = randomColumn();
            if (board[i][j].getValue() == 1) {
                int val = randomValue();
                board[i][j] = new Tile(val, colors[val], Color.BLACK);
                break;
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < BOARD_ROWS; i++) {
            for (int j = 0; j < BOARD_COLUMNS; j++) System.out.print(board[i][j].getValue() + " ");
            System.out.println();
        }
    }
}

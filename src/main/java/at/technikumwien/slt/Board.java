package at.technikumwien.slt;

public class Board {
    private char[][] cells;

    public Board() {
        cells = new char[3][3];
        clear();
    }

    public boolean isCellEmpty(int x, int y) {
        return cells[x][y] == ' ';
    }

    public void place(int x, int y, char marker) {
        cells[x][y] = marker;
    }

    public boolean isFull() {
        for (char[] row : cells) {
            for (char marker : row) {
                if (marker == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void clear() {
        for (int y = 0; y < cells.length; y++) {
            for (int x = 0; x < cells[y].length; x++) {
                cells[x][y] = ' ';
            }
        }
    }

    public void print() {
        System.out.println("-------------");
        for (int y = 0; y < cells.length; y++) {
            System.out.print("| ");
            for (int x = 0; x < cells[y].length; x++) {
                System.out.print(cells[x][y] + " | ");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }

    public char[][] getCells() {
        return cells;
    }
}

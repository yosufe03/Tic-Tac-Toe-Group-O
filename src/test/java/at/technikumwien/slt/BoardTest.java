package at.technikumwien.slt;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void isCellEmpty() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(board.isCellEmpty(i, j));
            }
        }
    }

    @Test
    void isCellEmptyReturnsFalseWhenACellIsFilled() {
        board.place(0,0, 'X');
        assertFalse(board.isCellEmpty(0, 0));

    }

    @Test
    void place() {
        board.place(0,0, 'X');
        assertSame('X', board.getCells()[0][0]);
    }

    @Test
    void placeOutOfBoundsThrowsException() {
        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> board.place(0,3, 'X'));
    }

    @Test
    void isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    @Test
    void isFullOnEmptyBoardReturnsFalse() {
        assertFalse(board.isFull());
    }

    @Test
    void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        board.clear();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertSame(' ', board.getCells()[i][j]);
            }
        }
    }

    @Test
    void clearOnEmptyBoard() {
        board.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertSame(' ', board.getCells()[i][j]);
            }
        }
    }

    @Test
    void print() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        board.print();
        String expected = "-------------\n" +
                "|   |   |   | \n" +
                "|   |   |   | \n" +
                "|   |   |   | \n" +
                "-------------\n";

        assertEquals(expected, outContent.toString());
        System.setOut(System.out);
    }

    @Test
    void printFullBoard() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }

        board.print();
        String expected = "-------------\n" +
                "| X | X | X | \n" +
                "| X | X | X | \n" +
                "| X | X | X | \n" +
                "-------------\n";

        assertEquals(expected, outContent.toString());
        System.setOut(System.out);
    }

    @Test
    void getCells() {
        char[][] expected = {
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' }
        };

        assertArrayEquals(expected, board.getCells());
    }

    @Test
    void getCellsOnFullBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }

        char[][] expected = {
                { 'X', 'X', 'X' },
                { 'X', 'X', 'X' },
                { 'X', 'X', 'X' }
        };

        assertArrayEquals(expected, board.getCells());
    }
}
package at.technikumwien.slt;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {
    private TicTacToe ticTacToe;

    @BeforeEach
    void setUp() {
        ticTacToe = new TicTacToe();
    }

    @Test
    void testGetInput_validFirstTry() {
        String simulatedInput = "0\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        assertEquals(0, ticTacToe.getInput(""));
        System.setIn(System.in);
    }

    @Test
    void testGetInput_invalidThenValid() {
        String simulatedInput = "3\n-1\n2\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        System.setIn(in);

        assertEquals(2, ticTacToe.getInput(""));
        System.setIn(System.in);
    }

    @Test
    void switchCurrentPlayer() {
        Player currentPlayer = ticTacToe.currentPlayer;
        ticTacToe.switchCurrentPlayer();

        assertNotEquals(currentPlayer, ticTacToe.currentPlayer);
    }

    @Test
    void switchCurrentPlayerMultiple() {
        for (int i = 0; i < 2; i++) {
            Player currentPlayer = ticTacToe.currentPlayer;
            ticTacToe.switchCurrentPlayer();

            assertNotEquals(currentPlayer, ticTacToe.currentPlayer);
        }
    }

    @Test
    void hasWinnerOnEmptyBoardReturnsFalse() {
        assertFalse(ticTacToe.hasWinner());
    }

    @Test
    void hasWinnerOnDrawBoardReturnsFalse() {
        char[][] drawBoard = {
            { 'X', 'O', 'X' },
            { 'X', 'X', 'O' },
            { 'O', 'X', 'O' }
        };

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                ticTacToe.board.place(row, col, drawBoard[row][col]);
            }
        }

        ticTacToe.board.print();
        assertFalse(ticTacToe.hasWinner());
    }

    @Test
    void hasWinnerRows() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ticTacToe.board.place(j, i, 'X');
            }
            ticTacToe.board.print();
            assertTrue(ticTacToe.hasWinner());
            ticTacToe.board.clear();
        }
    }

    @Test
    void hasWinnerColumns() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                ticTacToe.board.place(i, j, 'X');
            }
            ticTacToe.board.print();
            assertTrue(ticTacToe.hasWinner());
            ticTacToe.board.clear();
        }
    }

    @Test
    void hasWinnerDiagonal() {
        ticTacToe.board.place(0, 0, 'X');
        ticTacToe.board.place(1, 1, 'X');
        ticTacToe.board.place(2, 2, 'X');
        ticTacToe.board.print();
        assertTrue(ticTacToe.hasWinner());

        ticTacToe.board.clear();

        ticTacToe.board.place(0, 2, 'X');
        ticTacToe.board.place(1, 1, 'X');
        ticTacToe.board.place(2, 0, 'X');
        ticTacToe.board.print();
        assertTrue(ticTacToe.hasWinner());
    }
}
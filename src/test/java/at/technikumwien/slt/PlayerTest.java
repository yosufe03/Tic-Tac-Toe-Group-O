package at.technikumwien.slt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PlayerTest {
    private Player playerX;
    private Player playerO;

    @BeforeEach
    void setUp() {
        playerX = new Player('X');
        playerO = new Player('O');
    }

    @Test
    void getMarker() {
        assertEquals('X', playerX.getMarker());
        assertEquals('O', playerO.getMarker());
    }

    @Test
    void getMarkerNotSame() {
        assertNotEquals(playerX.getMarker(), playerO.getMarker());
    }
}
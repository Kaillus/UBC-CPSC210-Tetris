package tests;

import ui.model.paint.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSquare {

    private Square square;

    @BeforeEach
    public void setup() {
        square = new Square(Color.black);
    }

    @Test
    public void testColourChange() {
        assertTrue(square.isEmpty());
        System.out.println(square.isEmpty());
        assertEquals(Color.black, square.getColour());
        square.setFillColour(Color.red);
        assertFalse(square.isEmpty());
        System.out.println(square.isEmpty());
    }
}

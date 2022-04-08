package tests;

import model.paint.Square;
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
        square = new Square(Color.black,0,0);
    }

    @Test
    public void testColourChange() {
        assertTrue(square.isEmpty());
        System.out.println(square.isEmpty());
        assertEquals(Color.black, square.getColour());
        square.setColour(Color.red);
        assertFalse(square.isEmpty());
        System.out.println(square.isEmpty());
    }

    @Test
    public void testPositionChange() {
        System.out.println(square.getSquareX() + ", " + square.getSquareY());
        assertEquals(square.getSquareX(), 0);
        assertEquals(square.getSquareY(), 0);
        square.setPosition(1,-1);
        assertEquals(square.getSquareX(), 1);
        assertEquals(square.getSquareY(), -1);
        System.out.println(square.getSquareX() + ", " + square.getSquareY());
    }

}

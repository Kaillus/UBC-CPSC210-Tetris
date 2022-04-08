package tests;

import model.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSquare {

    private Square square;

    @BeforeEach
    public void setup() {
        square = new Square("black",0,0);
    }

    @Test
    public void testColourChange() {
        assertTrue(square.isEmpty());
        System.out.println(square.isEmpty());
        square.setColour("red");
        assertFalse(square.isEmpty());
        System.out.println(square.isEmpty());
    }

    @Test
    public void testPositionChange() {
        System.out.println(square.getX() + ", " + square.getY());
        assertEquals(square.getX(), 0);
        assertEquals(square.getY(), 0);
        square.setPosition(1,-1);
        assertEquals(square.getX(), 1);
        assertEquals(square.getY(), -1);
        System.out.println(square.getX() + ", " + square.getY());
    }

}

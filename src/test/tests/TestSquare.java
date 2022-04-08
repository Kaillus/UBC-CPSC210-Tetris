package tests;

import model.Square;

import org.junit.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class TestSquare {

    private Square square;

    @Before
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

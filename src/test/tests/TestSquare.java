package tests;

import model.Square;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class TestSquare {

    private Square square;

    @Before
    private void setup() {
        square = new Square(true,null,0,0);
    }

    @Test
    public void testEmpty() {
        assertTrue(Square.isEmpty(square));
        square.switchEmpty();
        assertFalse(Square.isEmpty(square));
    }
}

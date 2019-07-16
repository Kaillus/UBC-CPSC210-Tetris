package tests;

import logic.Board;

import model.Square;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class TestBoard {

    private Board testBoard;

    @Before
    public void initTestBoard() {
        testBoard = new Board(6,6);
    }

    @Test
    public void testPlaceOneAndFetchColour() {
        Square square = new Square("red",2,3);
        testBoard.placeOnBoard(square);
        assertEquals(testBoard.getColourByPos(2, 3), "red");
    }

}

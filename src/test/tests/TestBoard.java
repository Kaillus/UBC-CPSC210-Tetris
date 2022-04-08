package tests;

import logic.Board;

import model.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBoard {

    private Board testBoard;

    @BeforeEach
    public void initTestBoard() {
        testBoard = new Board(6,6);
    }

    @Test
    public void testPlaceOneAndFetchColour() {
        Square square = new Square("red",2,3);
        testBoard.placeOnBoard(square);
        assertEquals(testBoard.getColourByPos(2, 3), "red");
    }

    @Test
    public void getWrongColour() {
        Square testSquare = new Square("gray",3,3);
        testBoard.placeOnBoard(testSquare);
        assertEquals("black", testBoard.getColourByPos(3,3));
    }

}

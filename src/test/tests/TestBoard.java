package tests;

import logic.Board;

import model.paint.Square;
import model.pieces.IPiece;
import model.pieces.Piece;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestBoard {

    /*private Board testBoard;

    @BeforeEach
    public void initTestBoard() {
        testBoard = new Board(6, 7);
    }

    @Test
    public void testPlaceOneAndFetchColour() {
        Square square = new Square(Color.red,2,3);
        testBoard.placeOnBoard(square);
        assertEquals(Color.red, testBoard.getColourByPos(2, 3));
    }

    @Test
    public void testGetWrongColour() {
        Square testSquare = new Square(Color.gray,3,3);
        testBoard.placeOnBoard(testSquare);
        assertEquals(Color.black, testBoard.getColourByPos(3,3));
    }

    @Test
    public void testGetCurPiece() {
        assertEquals(null, testBoard.getCurrentPiece());
        testBoard.genPiece();
        assertFalse(testBoard.getCurrentPiece() == null);
        assertTrue(testBoard.getCurrentPiece() instanceof Piece);
    }

    @Test
    public void testSetCurPiece() {
        testBoard.genPiece();
        Piece testPiece = new IPiece();
        testBoard.setCurrentPiece(testPiece);
        assertTrue(testBoard.getCurrentPiece() instanceof IPiece);
    }

    @Test
    public void testGetDimensions() {
        assertEquals(7, testBoard.getBoardHeight());
        assertEquals(6, testBoard.getBoardWidth());
    }

    @Test
    public void testMoveDown() {
        testBoard.genPiece(true);
        Piece testPiece = new IPiece();
        testPiece.draw(testBoard, 5,1);
        assertEquals("cyan", testBoard.getColourByPos(5,1));
        assertEquals("cyan", testBoard.getColourByPos(5,2));
        assertEquals("cyan", testBoard.getColourByPos(5,3));
        assertEquals("cyan", testBoard.getColourByPos(5,4));
        assertEquals("black", testBoard.getColourByPos(5,5));
        testBoard.setCurrentPiece(testPiece);
        testBoard.updatePiece(testPiece);
        assertEquals("black", testBoard.getColourByPos(5,1));
        assertEquals("cyan", testBoard.getColourByPos(5,2));
        assertEquals("cyan", testBoard.getColourByPos(5,3));
        assertEquals("cyan", testBoard.getColourByPos(5,4));
        assertEquals("cyan", testBoard.getColourByPos(5,5));
        testBoard.updatePiece(testPiece);
        assertTrue(testBoard.getCurrentPiece() != testPiece);
        //assertFalse(testBoard.);
    }*/

}

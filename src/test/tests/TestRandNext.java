package tests;

import model.Animatable;
import ui.logic.Board;
import logic.RandNext;
import model.pieces.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestRandNext {

    private Board board = new Board(6,6);
    private Piece testObject;
    private RandNext randNext = new RandNext(board);

    @Test
    public void testSelect() {
        testObject = randNext.generatePiece("LPiece");
        assertTrue(testObject instanceof LPiece);
        testObject = randNext.generatePiece("IPiece");
        assertTrue(testObject instanceof IPiece);
        testObject = randNext.generatePiece("JPiece");
        assertTrue(testObject instanceof JPiece);
        testObject = randNext.generatePiece("OPiece");
        assertTrue(testObject instanceof OPiece);
        testObject = randNext.generatePiece("TPiece");
        assertTrue(testObject instanceof TPiece);
        testObject = randNext.generatePiece("SPiece");
        assertTrue(testObject instanceof SPiece);
        testObject = randNext.generatePiece("ZPiece");
        assertTrue(testObject instanceof ZPiece);
    }

    @Test
    public void testInitNext() {
        assertEquals(4, randNext.getSize());
    }

    @Test
    public void testNextPiece() {
        assertEquals(4, randNext.getSize());
        testObject = randNext.nextPiece();
        assertTrue(testObject instanceof Animatable);
        assertEquals(4, randNext.getSize());
    }

    /*@Test
    public void testGetRandom() {
        ArrayList<Piece> tempBag = new ArrayList<>();
        testObject = randNext.getRandom();
        Class cls = testObject.getClass();
        tempBag.add(testObject);
        for (Piece a : tempBag) {
            if (a instanceof cls)
        }
    }*/

}

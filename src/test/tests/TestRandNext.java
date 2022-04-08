package tests;

import org.junit.jupiter.api.BeforeEach;
import ui.Constants;
import ui.model.*;
import ui.logic.Board;
import model.RandNext;
import org.junit.jupiter.api.Test;
import ui.model.pieces.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestRandNext {

    private Board board;
    private Piece testObject;
    private RandNext randNext;

    @BeforeEach
    public void setup() {
        board = new Board(6,6);
        randNext = new RandNext(board);
    }

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
    public void testVerifyBagSize() {
        randNext.getSize();
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

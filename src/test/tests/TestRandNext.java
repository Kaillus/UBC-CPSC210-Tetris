package tests;

import logic.RandNext;
import model.Animatable;
import model.pieces.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestRandNext {

    private Animatable testObject;
    private RandNext randNext = new RandNext();

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
        randNext.initNext();
        assertEquals(4, randNext.getSize());
    }

    @Test
    public void testNextPiece() {
        randNext.initNext();
        assertEquals(4, randNext.getSize());
        testObject = randNext.nextPiece();
        assertTrue(testObject instanceof Animatable);
        assertEquals(4, randNext.getSize());
    }

    /*@Test
    public void testGetRandom() {
        ArrayList<Animatable> tempBag = new ArrayList<>();
        testObject = randNext.getRandom();
        Class cls = testObject.getClass();
        tempBag.add(testObject);
        for (Animatable a : tempBag) {
            if (a instanceof cls)
        }
    }*/
}

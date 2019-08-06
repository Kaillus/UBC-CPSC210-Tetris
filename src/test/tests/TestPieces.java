package tests;

import logic.Board;
import model.Animatable;

import model.pieces.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPieces {
/*
    private Board testBoard;

    @BeforeEach
    public void initTestBoard() {
        testBoard = new Board(6, 6);
    }

    @Test
    public void placeJ() {
        Animatable j = new JPiece();
        j.draw(testBoard,3, 0);
        assertEquals(testBoard.getColourByPos(2, 0), "blue");
        assertEquals(testBoard.getColourByPos(2, 1), "blue");
        assertEquals(testBoard.getColourByPos(3, 1), "blue");
        assertEquals(testBoard.getColourByPos(4, 1), "blue");
        System.out.println("Passed JPiece test");
    }

    @Test
    public void placeI() {
        Animatable i = new IPiece();
        i.draw(testBoard,3, 0);
        assertEquals(testBoard.getColourByPos(3, 0), "cyan");
        assertEquals(testBoard.getColourByPos(3, 1), "cyan");
        assertEquals(testBoard.getColourByPos(3, 2), "cyan");
        assertEquals(testBoard.getColourByPos(3, 3), "cyan");
        System.out.println("Passed IPiece test");
    }

    @Test
    public void placeL() {
        Animatable l = new LPiece();
        l.draw(testBoard,3, 0);
        assertEquals(testBoard.getColourByPos(4, 0), "orange");
        assertEquals(testBoard.getColourByPos(4, 1), "orange");
        assertEquals(testBoard.getColourByPos(3, 1), "orange");
        assertEquals(testBoard.getColourByPos(2, 1), "orange");
        System.out.println("Passed LPiece test");
    }

    @Test
    public void placeT() {
        Animatable t = new TPiece();
        t.draw(testBoard,3, 0);
        assertEquals(testBoard.getColourByPos(3, 0), "purple");
        assertEquals(testBoard.getColourByPos(4, 1), "purple");
        assertEquals(testBoard.getColourByPos(3, 1), "purple");
        assertEquals(testBoard.getColourByPos(2, 1), "purple");
        System.out.println("Passed TPiece test");
    }

    @Test
    public void placeO() {
        Animatable o = new OPiece();
        o.draw(testBoard,3, 0);
        assertEquals(testBoard.getColourByPos(3, 0), "yellow");
        assertEquals(testBoard.getColourByPos(3, 1), "yellow");
        assertEquals(testBoard.getColourByPos(2, 0), "yellow");
        assertEquals(testBoard.getColourByPos(2, 1), "yellow");
        System.out.println("Passed OPiece test");
    }

    @Test
    public void placeS() {
        Animatable s = new SPiece();
        s.draw(testBoard,3, 0);
        assertEquals(testBoard.getColourByPos(4, 0), "green");
        assertEquals(testBoard.getColourByPos(3, 0), "green");
        assertEquals(testBoard.getColourByPos(3, 1), "green");
        assertEquals(testBoard.getColourByPos(2, 1), "green");
        System.out.println("Passed SPiece test");
    }

    @Test
    public void placeZ() {
        Animatable z = new ZPiece();
        z.draw(testBoard,3, 0);
        assertEquals(testBoard.getColourByPos(2, 0), "red");
        assertEquals(testBoard.getColourByPos(3, 0), "red");
        assertEquals(testBoard.getColourByPos(3, 1), "red");
        assertEquals(testBoard.getColourByPos(4, 1), "red");
        System.out.println("Passed ZPiece test");
    }

    @AfterAll
    public static void testSuccess() {
        System.out.println("All seven pieces place on the board without issue");
    }

    */

}

package tests;

import model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.logic.Board;
import ui.model.PieceProxy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGame {

    private Game testGame1;
    private Game testGame;

    @BeforeEach
    private void setup() {
        testGame1 = Game.getInstance();
        testGame = Game.getInstance2();
    }

    @Test
    public void testBoard() {
        testGame.makeBoard();
        assertTrue(testGame.getGameBoard() != null);
        Board testBoard = testGame.getGameBoard();
        PieceProxy testProxy = testBoard.getProxy();
        assertTrue(testProxy instanceof PieceProxy);
    }
}

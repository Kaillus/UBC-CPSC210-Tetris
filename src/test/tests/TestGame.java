package tests;

import model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.logic.Board;
import ui.model.PieceProxy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestGame {

    private Game testGame;

    @BeforeEach
    private void setup() {
        testGame = Game.getInstance2();
    }

    @Test
    public void testBoard() {
        testGame.makeBoard();
        Board testBoard = testGame.getGameBoard();
        PieceProxy testProxy = testBoard.getProxy();
        assertTrue(testProxy instanceof PieceProxy);
    }
}

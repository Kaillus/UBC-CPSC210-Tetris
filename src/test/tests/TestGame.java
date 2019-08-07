package tests;

import logic.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.logic.Board;

public class TestGame {

    private Game testGame;

    @BeforeEach
    private void setup() {
        testGame = new Game();
    }

    @Test
    public void testBoard() {
        Board testBoard = testGame.getGameBoard();
    }
}

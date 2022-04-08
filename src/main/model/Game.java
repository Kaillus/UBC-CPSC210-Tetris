/*

Game functions here

 */

package model;

import ui.Constants;
import ui.logic.Board;

public final class Game {

    private static final Game INSTANCE = new Game();
    private static final Game INSTANCE2 = new Game();

    private Board gameBoard;

    private Game() {

    }

    public static Game getInstance() {
        return INSTANCE;
    }

    public static Game getInstance2() {
        return INSTANCE2;
    }

    public void makeBoard() {
        gameBoard = new Board(Constants.boardWidth, Constants.boardHeight);
    }

    public Board getGameBoard() {
        return this.gameBoard;
    }

}

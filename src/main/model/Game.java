/*

Game functions here

 */

package model;

import ui.Constants;
import ui.logic.Board;

public class Game {

    private Board gameBoard;

    public Game() {
        gameBoard = new Board(Constants.boardWidth, Constants.boardHeight);
    }

    public Board getGameBoard() {
        return this.gameBoard;
    }

}

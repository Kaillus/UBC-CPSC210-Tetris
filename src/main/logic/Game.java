/*

Game functions here

 */

package logic;

import ui.Board;

public class Game {

    public Board gameBoard;
    public final int boardHeight = 20;
    public final int boardWidth = 10;

    public Game() {
        gameBoard = new Board(boardWidth, boardHeight);
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public void saveBlock() {
        gameBoard.setSavedPiece();
    }


}

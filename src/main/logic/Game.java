/*

Game functions here

 */

package logic;

public class Game {


    //iterate through 2D space
    /*public boolean checkForLineFull() {
        for (int i = 0; i < board.boardHeight; i++ ) {
            for (int j = 0; j <= board.boardWidth; j++) {
               if (board.atPosition(j, i).empty) {
                   return false;
               }
            }
            return true

        }
        return true;
    }*/

    /*
    Loop interaction: iterate through board (a 2 dimensional array made up of Squares using a coordinate system)
    Iterate through the lowest row of Squares and check if any have parameter Square.empty set to true
    If so the line cannot be considered "full" and cannot be cleared
    If inner for loop successfully completes an iteration then outer for loop increases index by one and clears that
    row, checking the next row up
    */


    //EFFECTS: Iterate through given row in board and return true if no empty squares exist, false if otherwise
    // iterate through only one line at y coordinate
    /*public boolean checkForLineFull(int y) {
            for (int x = 0; x <= board.boardWidth; x++) {
               if (board.atPosition(x, y).empty) {
                   return false;
               }
            }
            return true
    }*/

    /*
    Loop interaction: iterate through row (an ordered array made up of Squares)
    Iterate through the input row of Squares and check if any have parameter Square.empty set to true
    If so the line cannot be considered "full" and cannot be cleared
    If inner for loop successfully completes an iteration then function returns true which is called by another method
    to check if given line can be cleared (and then clears it if checkForLineFull returns true)
    */

    public Board gameBoard;
    private int boardHeight = 20;
    private int boardWidth = 10;

    public void init() {
        gameBoard = new Board(boardHeight, boardWidth);
    }

    public void saveBlock() {
        gameBoard.setSavedPiece();
    }

    public boolean checkForLineFull() {
        boolean full = false;
        for (int i = 0; i < gameBoard.getBoardHeight(); i++) {
            for (int j = 0; j <= gameBoard.getBoardWidth(); j++) {
                full = !gameBoard.getColourByPos(j, i).equals("black");
            }
        }
        return full;
    }


}

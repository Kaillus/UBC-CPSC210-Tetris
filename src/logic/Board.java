package logic;

import model.Square;

public class Board {

    private int boardHeight;
    private int boardWidth;

    private int[][] gameBoard;

    private String[] colourKey = {"black","red","green","blue","orange","purple","cyan","yellow"};

    //MODIFIES: this
    //EFFECTS: builds a new Board
    public Board(int height, int width) {
        this.boardHeight = height;
        this.boardWidth = width;
        this.gameBoard = new int[this.boardHeight][this.boardWidth];
    }

    //EFFECTS: converts a Square's colour to a number for use in the Board
    private int colourKeyIndex(String string) {
        for (int i = 0; i < colourKey.length; i++) {
            if (colourKey[i] == string) {
                return i;
            }
        }
        return 0;
    }

    //MODIFIES: this
    //EFFECTS: places an input Square's colour's number conversion on the board
    public void placeOnBoard(Square square) {
        this.gameBoard[square.getY()][square.getX()] = colourKeyIndex(square.getColour());
    }

    //REQUIRES: board initialized
    //EFFECTS: returns colour located at input x, y
    public String getColourByPos(int x, int y) {
        return colourKey[gameBoard[y][x]];
    }

}

package logic;

import model.Animatable;
import model.Square;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Board {

    private int boardHeight;
    private int boardWidth;

    private int[][] gameBoard;

    private String[] colourKey = {"black","red","green","blue","orange","purple","cyan","yellow"};

    private Map<String, Animatable> boardPieces;
    private Animatable currentPiece;
    private int index;

    //MODIFIES: this
    //EFFECTS: builds a new Board
    public Board(int height, int width) {
        this.boardHeight = height;
        this.boardWidth = width;
        this.gameBoard = new int[this.boardHeight][this.boardWidth];
        this.boardPieces = new HashMap<>();
        this.index = 1;
    }

    //EFFECTS: converts a Square's colour to a number for use in the Board
    private int colourKeyIndex(String string) {
        for (int i = 0; i < colourKey.length; i++) {
            if (colourKey[i].equals(string)) {
                return i;
            }
        }
        return 0;
    }

    private void incrementIndex() {
        index = index + 1;
    }

    //MODIFIES: this
    //EFFECTS: places an input Square's colour's number conversion on the board
    public void placeOnBoard(Square square) {
        this.gameBoard[square.getY()][square.getX()] = colourKeyIndex(square.getColour());
    }

    private void genPiece() {
        //currentPiece = new RandNext.generatePiece();
        //boardPieces.replace("currentPiece", currentPiece)
    }

    private void nextPiece() {
        //currentPiece = new RandNext.nextPiece();
        //boardPieces.replace("currentPiece", currentPiece)
    }

    private void placeNextPiece(Animatable piece) {
        //String objName = "object" + Integer.toString(index);
        //boardPieces.put(objName, currentPiece)
        incrementIndex();
        nextPiece();
    }

    //REQUIRES: board initialized
    //EFFECTS: returns colour located at input x, y
    public String getColourByPos(int x, int y) {
        return colourKey[gameBoard[y][x]];
    }

}

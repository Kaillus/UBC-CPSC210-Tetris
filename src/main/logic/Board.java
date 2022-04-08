package logic;

import model.Animatable;
import model.Square;
import logic.RandNext;

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
    private Animatable savedPiece;
    private int index;
    private RandNext randNext = new RandNext();

    //MODIFIES: this
    //EFFECTS: builds a new Board
    public Board(int height, int width) {
        this.boardHeight = height;
        this.boardWidth = width;
        this.gameBoard = new int[this.boardHeight][this.boardWidth];
        this.boardPieces = new HashMap<>();
        this.currentPiece = null;
        this.savedPiece = null;
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

    //MODIFIES: this
    //EFFECTS: increments the index (number of objects on the board, concatenated to hashMap keys in placeNextPiece)
    private void incrementIndex() {
        index = index + 1;
    }

    //MODIFIES: this
    //EFFECTS: places an input Square's colour's number conversion on the board
    public void placeOnBoard(Square square) {
        this.gameBoard[square.getY()][square.getX()] = colourKeyIndex(square.getColour());
    }

    //REQUIRES: must be the first piece-generating method run
    //MODIFIES: this
    //EFFECTS: initializes the first piece and the upcoming pieces
    public void genPiece() {
        randNext.initNext();
        nextPiece();
    }

    //MODIFIES: this
    //EFFECTS: gets the next piece from the upcoming pieces
    public void nextPiece() {
        currentPiece = randNext.nextPiece();
        boardPieces.replace("currentPiece", currentPiece);
    }

    //MODIFIES: this
    //EFFECTS: if saved is true, switches the currentPiece with (and places) the input piece. else, moves the current
    //         piece to a new spot in the boardPieces hashmap (changing its key to object#) and
    //         increments the index + generates next piece
    public void placeNextPiece(Animatable piece, boolean saved) {
        if (!saved) {
            String objName = "object" + Integer.toString(index);
            boardPieces.put(objName, currentPiece);
            incrementIndex();
            nextPiece();
        } else {
            boardPieces.replace("currentPiece", piece);
        }
    }

    //MODIFIES: this
    //EFFECTS: if savedPiece doesn't exist, simply moves the currentPiece to the savedPiece and generates a new piece.
    //         otherwise, swaps the currentPiece with the savedPiece and places the old savedPiece on the board
    public void setSavedPiece() {
        if (savedPiece == null) {
            savedPiece = boardPieces.get("currentPiece");
            nextPiece();
        } else {
            Animatable tempCurrent = boardPieces.get("currentPiece");
            placeNextPiece(savedPiece, true);
            savedPiece = tempCurrent;
        }

    }

    //REQUIRES: board initialized
    //EFFECTS: returns colour located at input x, y
    public String getColourByPos(int x, int y) {
        return colourKey[gameBoard[y][x]];
    }

}

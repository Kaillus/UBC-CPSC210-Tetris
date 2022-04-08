package logic;

import model.Square;
import model.pieces.Piece;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Board {

    private int boardHeight;
    private int boardWidth;

    private int[][] gameBoard;

    private String[] colourKey = {"black", "red", "green", "blue", "orange", "purple", "cyan", "yellow"};

    private Map<String, Piece> boardPieces;
    private Piece currentPiece;
    private Piece savedPiece;
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

    public Piece getCurrentPiece() {
        return currentPiece;
    }

    public int getBoardHeight() {
        return this.boardHeight;
    }

    public int getBoardWidth() {
        return this.boardWidth;
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

    //REQUIRES: board initialized
    //EFFECTS: returns colour located at input x, y
    public String getColourByPos(int x, int y) {
        return colourKey[gameBoard[y][x]];
    }

    private boolean isFree(ArrayList<ArrayList<Integer>> coords, int x, int y) {
        ArrayList<Integer> tempCoords = new ArrayList<>();
        tempCoords.add(x);
        tempCoords.add(y);
        for (ArrayList<Integer> i : coords) {
            //if (!(getColourByPos(x, y).equals("black")) || (!coords.contains([x,y])));
            if (!((i == tempCoords) || (getColourByPos(x, y).equals("black")))) {
                return false;
            }
        }
        return true;
    }

    private boolean isValid(int x, int y) {
        return (x < boardWidth && y < boardHeight);
    }

    private boolean loopCheck(ArrayList<ArrayList<Integer>> coords, int newX, int newY) {
        boolean check = false;
        for (ArrayList<Integer> i : coords) {
            boolean nfree = !isFree(coords, i.get(0) + newX, (i.get(1)) + newY);
            boolean nvalid = !isValid(i.get(0) + newX, (i.get(1)) + newY);
            check = nfree && nvalid;
        }
        return check;
    }

    private boolean canMoveDown(ArrayList<ArrayList<Integer>> curCoords) {
        return loopCheck(curCoords,0,1);
    }

    private boolean canMoveLeft(ArrayList<ArrayList<Integer>> curCoords) {
        return loopCheck(curCoords,-1,0);
    }

    private boolean canMoveRight(ArrayList<ArrayList<Integer>> curCoords) {
        return loopCheck(curCoords,1,0);
    }

    //MR. TA: TRUST ME IT WORKS
    private boolean canMove(Piece piece, int dir) {
        ArrayList<ArrayList<Integer>> curCoords = piece.getPos();
        boolean movable = false;
        switch (dir) {
            case 1: //DOWN
                movable = canMoveDown(curCoords);
                break;
            case 2: //LEFT
                movable = canMoveLeft(curCoords);
                break;
            case 3: //RIGHT
                movable = canMoveRight(curCoords);
                break;
            default:
                break;
        }
        return movable;
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
    private void nextPiece() {
        currentPiece = randNext.nextPiece();
        boardPieces.replace("currentPiece", currentPiece);
    }

    //MODIFIES: this
    //EFFECTS: if saved is true, switches the currentPiece with (and places) the input piece. else, moves the current
    //         piece to a new spot in the boardPieces hashmap (changing its key to object#) and
    //         increments the index + generates next piece
    private void placeNextPiece(Piece piece, boolean saved) {
        if (!saved) {
            String objName = "object" + Integer.toString(index);
            boardPieces.put(objName, currentPiece);
            incrementIndex();
            nextPiece();
        } else {
            boardPieces.replace("currentPiece", piece);
        }
    }

    public void updatePiece(Piece piece) {
        if (canMove(piece, 1)) {
            piece.moveDown();
        } else {
            nextPiece();
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
            Piece tempCurrent = boardPieces.get("currentPiece");
            placeNextPiece(savedPiece, true);
            savedPiece = tempCurrent;
        }

    }

}

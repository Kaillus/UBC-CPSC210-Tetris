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

    //MODIFIES: this
    //EFFECTS: checks to see if the given coordinates are in the list of current coordinates or are empty spaces
    //         current coordinates meaning they're part of the current block, and so if the piece moves that way
    //         it won't be moving into a conflicting spot
    private boolean isFree(ArrayList<ArrayList<Integer>> coords, int x, int y) {
        ArrayList<Integer> tempCoords = new ArrayList<>();
        tempCoords.add(x);
        tempCoords.add(y);
        for (ArrayList<Integer> i : coords) {
            if (!((i == tempCoords) || (getColourByPos(x, y).equals("black")))) {
                return false;
            }
        }
        return true;
    }

    //EFFECTS: checks to see if the given coordinates are within the bounds of the board
    private boolean isValid(int x, int y) {
        return (x < boardWidth && y < boardHeight);
    }

    //EFFECTS: checks to see if all the given coordinates can be moved to a new set of coordinates.
    //         in coords, x is index 0 and y is index 1 where newX and newY are the delta value (of movement) ie. dx, dy
    private boolean loopCheck(ArrayList<ArrayList<Integer>> coords, int newX, int newY) {
        boolean check = false;
        for (ArrayList<Integer> i : coords) {
            boolean nfree = !isFree(coords, i.get(0) + newX, (i.get(1)) + newY);
            boolean nvalid = !isValid(i.get(0) + newX, (i.get(1)) + newY);
            check = nfree && nvalid;
        }
        return check;
    }

    //EFFECTS: checks to see if a piece can move in the input direction and returns a boolean based on testing.
    //         the input values to loopCheck are in terms of dx and dy - if newX is 1, loopCheck checks to see if
    //         movement to the current x values + 1 are possible and same for newY
    private boolean canMove(Piece piece, int dir) {
        ArrayList<ArrayList<Integer>> curCoords = piece.getPos();
        boolean movable = false;
        switch (dir) {
            case 1: //DOWN
                movable = loopCheck(curCoords,0,1);
                break;
            case 2: //LEFT
                movable = loopCheck(curCoords,-1,0);
                break;
            case 3: //RIGHT
                movable = loopCheck(curCoords,1,0);
                break;
            default:
                break;
        }
        return movable;
    }

    //MODIFIES: this
    //EFFECTS: if possible, moves the entire piece down one row on the board. if not, generate the next piece (because
    //         if the piece is unable to move, that means it must be in its final state)
    public void updatePiece(Piece piece) {
        if (canMove(piece, 1)) {
            piece.moveDown();
        } else {
            nextPiece();
        }
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

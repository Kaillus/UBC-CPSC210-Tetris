/*

Generates next pieces for use in game

 */


package logic;

import ui.Constants;
import ui.logic.Board;
import ui.model.pieces.*;

import java.util.ArrayList;
import java.util.Collections;

public class RandNext {

    private static ArrayList<String> baseBag = new ArrayList<>();
    private ArrayList<Piece> currentBag;
    private Piece targetPiece;
    private int sevenSetCounter;
    private Board board;

    static {
        baseBag.add("LPiece");
        baseBag.add("JPiece");
        baseBag.add("TPiece");
        baseBag.add("IPiece");
        baseBag.add("OPiece");
        baseBag.add("ZPiece");
        baseBag.add("SPiece");
    }

    public RandNext(Board board) {
        this.currentBag = new ArrayList<>();
        this.sevenSetCounter = 6;
        this.board = board;
        currentBag.add(getRandom());
        currentBag.add(getRandom());
        currentBag.add(getRandom());
        currentBag.add(getRandom());
    }

    //MODIFIES: this
    //EFFECTS: the bag is a set of 7 pieces. getRandom() shuffles the bag and then pulls out each piece so there are
    //         no repeating pieces and then shuffles the bag again once all pieces have been selected once
    private Piece getRandom() {
        if (sevenSetCounter == 6) {
            Collections.shuffle(baseBag);
            sevenSetCounter = 0;
        } else {
            sevenSetCounter = sevenSetCounter + 1;
        }
        return generatePiece(baseBag.get(sevenSetCounter));
    }

    //MODIFIES: this
    //EFFECTS: returns and removes the first (latest) entry in the pieces coming up and generates a new one at the tail
    public Piece nextPiece() {
        Piece latest = currentBag.get(0);
        currentBag.remove(0);
        currentBag.add(getRandom());
        return latest;
    }

    //MODIFIES: this
    //EFFECTS: uses getRandom() to generate a piece and then constructs a new object based on that piece via
    //         switch statements (two methods because checkstyle limits one method to 20 lines)
    public Piece generatePiece(String temp) {
        switch (temp) {
            case "LPiece":
                targetPiece = new LPiece(board, (board.getBoardWidth() / 2) * Constants.blockSize, 0);
                break;
            case "JPiece":
                targetPiece = new JPiece(board, (board.getBoardWidth() / 2) * Constants.blockSize, 0);
                break;
            case "TPiece":
                targetPiece = new TPiece(board, (board.getBoardWidth() / 2) * Constants.blockSize, 0);
                break;
            default:
                switchExtend(temp);
                break;
        }
        return targetPiece;
    }

    private void switchExtend(String temp) {
        switch (temp) {
            case "IPiece":
                targetPiece = new IPiece(board, (board.getBoardWidth() / 2) * Constants.blockSize, 0);
                break;
            case "OPiece":
                targetPiece = new OPiece(board, (board.getBoardWidth() / 2) * Constants.blockSize, 0);
                break;
            case "ZPiece":
                targetPiece = new ZPiece(board, (board.getBoardWidth() / 2) * Constants.blockSize, 0);
                break;
            default:
                targetPiece = new SPiece(board, (board.getBoardWidth() / 2) * Constants.blockSize, 0);
                break;
        }
    }

    public int getSize() {
        return currentBag.size();
    }

}
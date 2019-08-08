package ui.model.pieces;

import ui.logic.Board;
import ui.Constants;

import java.awt.*;

public class LPiece extends Piece {

    public LPiece(Board board, int x, int y) {
        super(board, Color.orange);
        setPos(x, y);
    }

    public void setPos(int x, int y) {
        one.setLocation(x + Constants.blockSize, y);
        two.setLocation(x + Constants.blockSize, y + Constants.blockSize);
        thr.setLocation(x, y + Constants.blockSize);
        fou.setLocation(x - Constants.blockSize, y + Constants.blockSize);
    }

}

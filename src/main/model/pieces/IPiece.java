package model.pieces;

import ui.logic.Board;
import ui.Constants;

import java.awt.*;

public class IPiece extends Piece {

    public IPiece(Board board, int x, int y) {
        super(board, Color.cyan);
        setPos(x, y);
    }

    public void setPos(int x, int y) {
        xpos = x;
        ypos = y;
        one.setLocation(x, y);
        two.setLocation(x, y + Constants.blockSize);
        thr.setLocation(x, y + (2 * Constants.blockSize));
        fou.setLocation(x, y + (3 * Constants.blockSize));
    }

}

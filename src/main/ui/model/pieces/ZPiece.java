package ui.model.pieces;

import ui.logic.Board;
import ui.Constants;

import java.awt.*;

public class ZPiece extends Piece {

    public ZPiece(Board board, int x, int y) {
        super(board, Color.red);
        setPos(x, y);
    }

    public void setPos(int x, int y) {
        xpos = x;
        ypos = y;
        one.setLocation(x - Constants.blockSize, y);
        two.setLocation(x, y);
        thr.setLocation(x, y + Constants.blockSize);
        fou.setLocation(x + Constants.blockSize, y + Constants.blockSize);
    }

}

package ui.model.pieces;

import ui.logic.Board;
import ui.Constants;

import java.awt.*;

public class TPiece extends Piece {

    public TPiece(Board board, int x, int y) {
        super(board, Color.magenta);
        setPos(x, y);
    }

    public void setPos(int x, int y) {
        xpos = x;
        ypos = y;
        one.setLocation(x, y);
        two.setLocation(x, y + Constants.blockSize);
        thr.setLocation(x - Constants.blockSize, y + Constants.blockSize);
        fou.setLocation(x + Constants.blockSize, y + Constants.blockSize);
    }

}

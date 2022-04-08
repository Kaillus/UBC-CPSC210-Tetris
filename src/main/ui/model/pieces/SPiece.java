package ui.model.pieces;

import ui.logic.Board;
import ui.Constants;

import java.awt.*;

public class SPiece extends Piece {

    public SPiece(Board board, int x, int y) {
        super(board, Color.green);
        setPos(x, y);
    }

    public void setPos(int x, int y) {
        one.setLocation(x + Constants.blockSize, y);
        two.setLocation(x, y);
        thr.setLocation(x, y + Constants.blockSize);
        fou.setLocation(x - Constants.blockSize, y + Constants.blockSize);
    }

}

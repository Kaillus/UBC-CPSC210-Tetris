package model.pieces;

import model.paint.Square;
import ui.Board;
import ui.Constants;

import java.awt.*;

public class OPiece extends Piece {

    public OPiece(Board board, int x, int y) {
        super(board, Color.yellow);
        setPos(x, y);
    }

    public void setPos(int x, int y) {
        one.setLocation(x, y);
        two.setLocation(x, y + Constants.blockSize);
        thr.setLocation(x - Constants.blockSize, y);
        fou.setLocation(x - Constants.blockSize, y + Constants.blockSize);
    }

}

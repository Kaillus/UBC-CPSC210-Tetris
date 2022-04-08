package ui.model.pieces;

import ui.logic.Board;
import ui.Constants;
import ui.model.paint.Square;

import java.awt.*;

public class JPiece extends Piece {

    public JPiece(Board board, int x, int y) {
        super(board, Color.blue);
        setPos(x, y);
    }

    public void setPos(int x, int y) {
        xpos = x;
        ypos = y;
        one.setLocation(x - Constants.blockSize, y);
        two.setLocation(x - Constants.blockSize, y + Constants.blockSize);
        thr.setLocation(x, y + Constants.blockSize);
        fou.setLocation(x + Constants.blockSize, y + Constants.blockSize);
    }
}

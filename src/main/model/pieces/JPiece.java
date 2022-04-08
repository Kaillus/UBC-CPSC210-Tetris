package model.pieces;

import model.paint.Square;
import ui.logic.Board;
import ui.Constants;

import java.awt.*;

public class JPiece extends Piece {

    public JPiece(Board board, int x, int y) {
        super(board, Color.blue);
        setPos(x, y);
    }

    public void setPos(int x, int y) {
        Square one = new Square(Color.blue, x - 1, y);
        Square two = new Square(Color.blue, x - 1, y + 1);
        Square thr = new Square(Color.blue, x, y + 1);
        Square fou = new Square(Color.blue, x + 1, y + 1);
        one.setLocation(x - Constants.blockSize, y);
        two.setLocation(x - Constants.blockSize, y + Constants.blockSize);
        thr.setLocation(x, y + Constants.blockSize);
        fou.setLocation(x + Constants.blockSize, y + Constants.blockSize);
    }
}

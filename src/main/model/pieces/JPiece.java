package model.pieces;

import logic.Board;
import model.Animatable;
import model.Square;

public class JPiece extends Piece {

    @Override
    public void draw(Board board, int x, int y) {
        Square one = new Square("blue", x - 1, y);
        Square two = new Square("blue", x - 1, y + 1);
        Square thr = new Square("blue", x, y + 1);
        Square fou = new Square("blue", x + 1, y + 1);
        board.placeOnBoard(one);
        board.placeOnBoard(two);
        board.placeOnBoard(thr);
        board.placeOnBoard(fou);
    }
}

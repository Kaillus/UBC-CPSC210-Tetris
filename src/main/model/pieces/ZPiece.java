package model.pieces;

import logic.Board;
import model.Animatable;
import model.Square;

public class ZPiece extends Piece {

    @Override
    public void draw(Board board, int x, int y) {
        Square one = new Square("red", x - 1, y);
        Square two = new Square("red", x, y);
        Square thr = new Square("red", x, y + 1);
        Square fou = new Square("red", x + 1, y + 1);
        board.placeOnBoard(one);
        board.placeOnBoard(two);
        board.placeOnBoard(thr);
        board.placeOnBoard(fou);
    }

}

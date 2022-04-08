package model.pieces;

import logic.Board;
import model.Animatable;
import model.Square;

public class SPiece extends Piece {

    @Override
    public void draw(Board board, int x, int y) {
        Square one = new Square("green", x + 1, y);
        Square two = new Square("green", x, y);
        Square thr = new Square("green", x, y + 1);
        Square fou = new Square("green", x - 1, y + 1);
        board.placeOnBoard(one);
        board.placeOnBoard(two);
        board.placeOnBoard(thr);
        board.placeOnBoard(fou);
    }

}

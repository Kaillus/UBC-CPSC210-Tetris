package model.pieces;

import logic.Board;
import model.Square;

import model.Animatable;

import java.util.ArrayList;

public class IPiece extends Piece {

    @Override
    public void draw(Board board, int x, int y) {
        Square two = new Square("cyan", x, y);
        Square thr = new Square("cyan", x, y + 1);
        Square fou = new Square("cyan", x, y + 2);
        Square one = new Square("cyan", x, y + 3);
        board.placeOnBoard(one);
        board.placeOnBoard(two);
        board.placeOnBoard(thr);
        board.placeOnBoard(fou);
    }

}

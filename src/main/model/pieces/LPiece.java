package model.pieces;

import logic.Board;
import model.paint.Square;

import java.awt.*;

public class LPiece extends Piece {

    public LPiece(Board board, int x, int y) {
        super(board, Color.orange);
        Square one = new Square(Color.orange, x + 1, y);
        Square two = new Square(Color.orange, x + 1, y + 1);
        Square thr = new Square(Color.orange, x, y + 1);
        Square fou = new Square(Color.orange, x - 1, y + 1);
        board.placeOnBoard(one);
        board.placeOnBoard(two);
        board.placeOnBoard(thr);
        board.placeOnBoard(fou);
    }

    @Override
    public void draw(Board board, int x, int y) {
        Square one = new Square(Color.orange, x + 1, y);
        Square two = new Square(Color.orange, x + 1, y + 1);
        Square thr = new Square(Color.orange, x, y + 1);
        Square fou = new Square(Color.orange, x - 1, y + 1);
        board.placeOnBoard(one);
        board.placeOnBoard(two);
        board.placeOnBoard(thr);
        board.placeOnBoard(fou);
    }

}

package model.pieces;

import logic.Board;
import model.paint.Square;

import java.awt.*;

public class OPiece extends Piece {

    public OPiece(Board board, int x, int y) {
        super(board, Color.yellow);
        Square one = new Square(Color.yellow, x, y);
        Square two = new Square(Color.yellow, x, y + 1);
        Square thr = new Square(Color.yellow, x - 1, y);
        Square fou = new Square(Color.yellow, x - 1, y + 1);
        board.placeOnBoard(one);
        board.placeOnBoard(two);
        board.placeOnBoard(thr);
        board.placeOnBoard(fou);
    }

    @Override
    public void draw(Board board, int x, int y) {
        Square one = new Square(Color.yellow, x, y);
        Square two = new Square(Color.yellow, x, y + 1);
        Square thr = new Square(Color.yellow, x - 1, y);
        Square fou = new Square(Color.yellow, x - 1, y + 1);
        board.placeOnBoard(one);
        board.placeOnBoard(two);
        board.placeOnBoard(thr);
        board.placeOnBoard(fou);
    }

}

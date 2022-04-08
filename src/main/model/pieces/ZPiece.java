package model.pieces;

import logic.Board;
import model.paint.Square;

import java.awt.*;

public class ZPiece extends Piece {

    public ZPiece(Board board, int x, int y) {
        super(board, Color.red);
        Square one = new Square(Color.red, x - 1, y);
        Square two = new Square(Color.red, x, y);
        Square thr = new Square(Color.red, x, y + 1);
        Square fou = new Square(Color.red, x + 1, y + 1);
        board.placeOnBoard(one);
        board.placeOnBoard(two);
        board.placeOnBoard(thr);
        board.placeOnBoard(fou);
    }

    @Override
    public void draw(Board board, int x, int y) {
        Square one = new Square(Color.red, x - 1, y);
        Square two = new Square(Color.red, x, y);
        Square thr = new Square(Color.red, x, y + 1);
        Square fou = new Square(Color.red, x + 1, y + 1);
        board.placeOnBoard(one);
        board.placeOnBoard(two);
        board.placeOnBoard(thr);
        board.placeOnBoard(fou);
    }

}

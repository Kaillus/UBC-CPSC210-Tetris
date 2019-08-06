package model.pieces;

import logic.Board;
import model.paint.Square;

import java.awt.*;

public class SPiece extends Piece {

    public SPiece(Board board, int x, int y) {
        super(board, Color.green);
        Square one = new Square(Color.green, x + 1, y);
        Square two = new Square(Color.green, x, y);
        Square thr = new Square(Color.green, x, y + 1);
        Square fou = new Square(Color.green, x - 1, y + 1);
        board.placeOnBoard(one);
        board.placeOnBoard(two);
        board.placeOnBoard(thr);
        board.placeOnBoard(fou);
    }

    @Override
    public void draw(Board board, int x, int y) {
        Square one = new Square(Color.green, x + 1, y);
        Square two = new Square(Color.green, x, y);
        Square thr = new Square(Color.green, x, y + 1);
        Square fou = new Square(Color.green, x - 1, y + 1);
        board.placeOnBoard(one);
        board.placeOnBoard(two);
        board.placeOnBoard(thr);
        board.placeOnBoard(fou);
    }

}

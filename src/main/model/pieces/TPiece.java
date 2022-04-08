package model.pieces;

import logic.Board;
import model.paint.Square;

import java.awt.*;

public class TPiece extends Piece {

    public TPiece(Board board, int x, int y) {
        super(board, Color.magenta);
        Square one = new Square(Color.magenta, x, y);
        Square two = new Square(Color.magenta, x, y + 1);
        Square thr = new Square(Color.magenta, x - 1, y + 1);
        Square fou = new Square(Color.magenta, x + 1, y + 1);
        board.placeOnBoard(one);
        board.placeOnBoard(two);
        board.placeOnBoard(thr);
        board.placeOnBoard(fou);
    }


    @Override
    public void draw(Board board, int x, int y) {
        Square one = new Square(Color.magenta, x, y);
        Square two = new Square(Color.magenta, x, y + 1);
        Square thr = new Square(Color.magenta, x - 1, y + 1);
        Square fou = new Square(Color.magenta, x + 1, y + 1);
        board.placeOnBoard(one);
        board.placeOnBoard(two);
        board.placeOnBoard(thr);
        board.placeOnBoard(fou);
    }

}

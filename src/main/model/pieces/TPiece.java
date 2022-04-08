package model.pieces;

import logic.Board;
import model.Animatable;
import model.Square;

public class TPiece implements Animatable {

    private Square one;
    private Square two;
    private Square thr;
    private Square fou;

    @Override
    public void draw(Board board, int x, int y) {
        Square one = new Square("purple", x, y);
        Square two = new Square("purple", x, y + 1);
        Square thr = new Square("purple", x - 1, y + 1);
        Square fou = new Square("purple", x + 1, y + 1);
        board.placeOnBoard(one);
        board.placeOnBoard(two);
        board.placeOnBoard(thr);
        board.placeOnBoard(fou);
    }

    @Override
    public void update(){
        //TODO: fall, etc
    }
}

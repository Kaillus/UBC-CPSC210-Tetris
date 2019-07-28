package model.pieces;

import logic.Board;
import model.Square;

import model.Animatables;

public class IPiece implements Animatables {

    private Square one;
    private Square two;
    private Square thr;
    private Square fou;

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

    @Override
    public void update(){
        //TODO: fall, etc
    }
}

package model.pieces;

import logic.Board;
import logic.Constants;
import model.Animatables;
import model.Square;

public class JPiece implements Animatables {

    private Square one;
    private Square two;
    private Square thr;
    private Square fou;

    @Override
    public void draw(Board board, int x, int y) {
        Square one = new Square("blue", x - 1, y);
        Square two = new Square("blue", x - 1, y + 1);
        Square thr = new Square("blue", x, y + 1);
        Square fou = new Square("blue", x + 1, y + 1);
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

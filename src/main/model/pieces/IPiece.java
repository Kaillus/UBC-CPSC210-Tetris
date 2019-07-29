package model.pieces;

import logic.Board;
import model.Square;

import model.Animatable;

import java.util.ArrayList;

public class IPiece implements Animatable {

    private Square one;
    private Square two;
    private Square thr;
    private Square fou;

    /*private ArrayList<Square> piece;

    private boolean active;

    private void setActive(boolean set) {
        this.active = set;
    }

    private void enable() {
        this.active = true;
    }

    private void disable() {
        this.active = false;
    }

    public void init(int x, int y) {
        Square two = new Square("cyan", x, y);
        Square thr = new Square("cyan", x, y + 1);
        Square fou = new Square("cyan", x, y + 2);
        Square one = new Square("cyan", x, y + 3);
        piece.add(one);
        piece.add(two);
        piece.add(thr);
        piece.add(fou);
        enable();
    }

    public void place(Board board, Square square) {
        board.placeOnBoard(square);
    }

    //@Override
    public void draw(Board board, int x, int y) {
        init(x, y);
        for (Square s : piece) {
            place(board, s);
        }
    }*/

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

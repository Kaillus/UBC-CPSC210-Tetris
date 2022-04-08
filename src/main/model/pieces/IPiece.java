package model.pieces;

import logic.Board;

import java.awt.*;

public class IPiece extends Piece {

    public IPiece(Board board, int x, int y) {
        super(board, Color.cyan);
        setOne(Color.cyan, x, y);
        setTwo(Color.cyan, x, y + 1);
        setThr(Color.cyan, x, y + 2);
        setFou(Color.cyan, x, y + 3);
        board.placeOnBoard(one);
        board.placeOnBoard(two);
        board.placeOnBoard(thr);
        board.placeOnBoard(fou);
    }

    @Override
    public void draw(Board board, int x, int y) {
        setOne(Color.cyan, x, y);
        setTwo(Color.cyan, x, y + 1);
        setThr(Color.cyan, x, y + 2);
        setFou(Color.cyan, x, y + 3);
        board.placeOnBoard(one);
        board.placeOnBoard(two);
        board.placeOnBoard(thr);
        board.placeOnBoard(fou);
    }

}

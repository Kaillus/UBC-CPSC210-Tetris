package model.pieces;

import logic.Board;
import model.paint.Paintable;
import model.Animatable;
import model.paint.Square;
import model.paint.SmartRectangle;
import ui.Constants;
import ui.PieceObserver;
import ui.PieceSubject;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Piece extends PieceSubject implements Animatable, Paintable {

    protected Square one;
    protected Square two;
    protected Square thr;
    protected Square fou;

    protected Color colour;
    protected Board board;

    public Piece(Board board, Color colour) {
        this.colour = colour;
        one = new Square(colour);
        two = new Square(colour);
        thr = new Square(colour);
        fou = new Square(colour);
        this.board = board;
    }

    @Override
    public void fill(java.awt.Graphics2D brush) {
        one.fill(brush);
        two.fill(brush);
        thr.fill(brush);
        fou.fill(brush);
    }

    @Override
    public void draw(java.awt.Graphics2D brush) {
        one.draw(brush);
        two.draw(brush);
        thr.draw(brush);
        fou.draw(brush);
    }

    protected void setOne(Color colour, int x, int y) {
        this.one = new Square(colour,x,y);
    }

    protected void setTwo(Color colour, int x, int y) {
        this.two = new Square(colour,x,y);
    }

    protected void setThr(Color colour, int x, int y) {
        this.thr = new Square(colour,x,y);
    }

    protected void setFou(Color colour, int x, int y) {
        this.fou = new Square(colour,x,y);
    }

    public void moveLeft() {
        //notifyObservers();
    }

    public void moveRight() {
        //notifyObservers();
    }

    public void moveDown() {
        one.setPosition(one.getSquareX(), one.getSquareY() + 1);
        two.setPosition(two.getSquareX(), two.getSquareY() + 1);
        thr.setPosition(thr.getSquareX(), thr.getSquareY() + 1);
        fou.setPosition(fou.getSquareX(), fou.getSquareY() + 1);
        notifyObservers(one, 1);
        notifyObservers(two, 1);
        notifyObservers(thr, 1);
        notifyObservers(fou, 1);
    }

    public ArrayList<ArrayList<Integer>> getPos() {
        ArrayList<ArrayList<Integer>> squarePos = new ArrayList<>();
        ArrayList<Integer> onePos = new ArrayList<>();
        onePos.add(one.getSquareX());
        onePos.add(one.getSquareY());
        squarePos.add(onePos);
        ArrayList<Integer> twoPos = new ArrayList<>();
        twoPos.add(two.getSquareX());
        twoPos.add(two.getSquareY());
        squarePos.add(twoPos);
        ArrayList<Integer> thrPos = new ArrayList<>();
        thrPos.add(thr.getSquareX());
        thrPos.add(thr.getSquareY());
        squarePos.add(thrPos);
        ArrayList<Integer> fouPos = new ArrayList<>();
        fouPos.add(fou.getSquareX());
        fouPos.add(fou.getSquareY());
        squarePos.add(fouPos);

        return squarePos;
    }

}

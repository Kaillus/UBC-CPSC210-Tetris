package model.pieces;

import model.Animatable;
import model.Square;

import java.util.ArrayList;

public abstract class Piece implements Animatable {

    protected Square one;
    protected Square two;
    protected Square thr;
    protected Square fou;

    public void moveLeft() {

    }

    public void moveRight() {

    }

    public void moveDown() {
        one.setPosition(one.getX(), one.getY() + 1);
        two.setPosition(two.getX(), two.getY() + 1);
        thr.setPosition(thr.getX(), thr.getY() + 1);
        fou.setPosition(fou.getX(), fou.getY() + 1);
    }

    public ArrayList<ArrayList<Integer>> getPos() {
        ArrayList<ArrayList<Integer>> squarePos = new ArrayList<>();
        ArrayList<Integer> onePos = new ArrayList<>();
        onePos.add(one.getX());
        onePos.add(one.getY());
        squarePos.add(onePos);
        ArrayList<Integer> twoPos = new ArrayList<>();
        twoPos.add(two.getX());
        twoPos.add(two.getY());
        squarePos.add(twoPos);
        ArrayList<Integer> thrPos = new ArrayList<>();
        thrPos.add(thr.getX());
        thrPos.add(thr.getY());
        squarePos.add(thrPos);
        ArrayList<Integer> fouPos = new ArrayList<>();
        fouPos.add(fou.getX());
        fouPos.add(fou.getY());
        squarePos.add(fouPos);

        return squarePos;
    }

}

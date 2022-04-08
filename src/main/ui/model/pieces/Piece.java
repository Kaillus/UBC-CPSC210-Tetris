package ui.model.pieces;

import ui.logic.Board;
import ui.Constants;
import ui.model.Animatable;
import ui.model.paint.Square;

import java.awt.*;

public abstract class Piece implements Animatable {

    protected Square one;
    protected Square two;
    protected Square thr;
    protected Square fou;

    protected int xpos;
    protected int ypos;
    protected Color colour;
    protected Board board;

    public Piece(Board board, Color colour) {
        this.colour = colour;
        one = new Square(colour);
        one.setSize(Constants.blockSize, Constants.blockSize);
        two = new Square(colour);
        two.setSize(Constants.blockSize, Constants.blockSize);
        thr = new Square(colour);
        thr.setSize(Constants.blockSize, Constants.blockSize);
        fou = new Square(colour);
        fou.setSize(Constants.blockSize, Constants.blockSize);
        this.board = board;
    }

    public void draw(Graphics2D brush) {
        one.draw(brush);
        two.draw(brush);
        thr.draw(brush);
        fou.draw(brush);
    }

    public void fill(Graphics2D brush) {
        one.fill(brush);
        two.fill(brush);
        thr.fill(brush);
        fou.fill(brush);
    }


    public abstract void setPos(int x, int y);

    public Square getOne() {
        return one;
    }

    public Square getTwo() {
        return two;
    }

    public Square getThr() {
        return thr;
    }

    public Square getFou() {
        return fou;
    }

    public boolean moveLeft() {
        System.out.println("left");
        int newx1 = (int) one.getX() - Constants.blockSize;
        int newx2 = (int) two.getX() - Constants.blockSize;
        int newx3 = (int) thr.getX() - Constants.blockSize;
        int newx4 = (int) fou.getX() - Constants.blockSize;
        boolean block1 = board.canMove(newx1 / Constants.blockSize, (int) one.getY() / Constants.blockSize);
        boolean block2 = board.canMove(newx2 / Constants.blockSize, (int) two.getY() / Constants.blockSize);
        boolean block3 = board.canMove(newx3 / Constants.blockSize, (int) thr.getY() / Constants.blockSize);
        boolean block4 = board.canMove(newx4 / Constants.blockSize, (int) fou.getY() / Constants.blockSize);

        if (block1 && block2 && block3 && block4) {
            one.setLocation(newx1,one.getY());
            two.setLocation(newx2,two.getY());
            thr.setLocation(newx3,thr.getY());
            fou.setLocation(newx4,fou.getY());
            return true;
        } else {
            return false;
        }
    }

    public boolean moveRight() {
        System.out.println("right");
        int newx1 = (int) one.getX() + Constants.blockSize;
        int newx2 = (int) two.getX() + Constants.blockSize;
        int newx3 = (int) thr.getX() + Constants.blockSize;
        int newx4 = (int) fou.getX() + Constants.blockSize;
        boolean block1 = board.canMove(newx1 / Constants.blockSize, (int) one.getY() / Constants.blockSize);
        boolean block2 = board.canMove(newx2 / Constants.blockSize, (int) two.getY() / Constants.blockSize);
        boolean block3 = board.canMove(newx3 / Constants.blockSize, (int) thr.getY() / Constants.blockSize);
        boolean block4 = board.canMove(newx4 / Constants.blockSize, (int) fou.getY() / Constants.blockSize);

        if (block1 && block2 && block3 && block4) {
            one.setLocation(newx1,one.getY());
            two.setLocation(newx2,two.getY());
            thr.setLocation(newx3,thr.getY());
            fou.setLocation(newx4,fou.getY());
            return true;
        } else {
            return false;
        }
    }

    public boolean moveDown() {
        int newy1 = (int) one.getY() + Constants.blockSize;
        int newy2 = (int) two.getY() + Constants.blockSize;
        int newy3 = (int) thr.getY() + Constants.blockSize;
        int newy4 = (int) fou.getY() + Constants.blockSize;

        boolean block1 = board.canMove((int) one.getY() / Constants.blockSize, newy1 / Constants.blockSize);
        boolean block2 = board.canMove((int) two.getY() / Constants.blockSize, newy2 / Constants.blockSize);
        boolean block3 = board.canMove((int) thr.getY() / Constants.blockSize, newy3 / Constants.blockSize);
        boolean block4 = board.canMove((int) fou.getY() / Constants.blockSize, newy4 / Constants.blockSize);

        if (block1 && block2 && block3 && block4) {
            one.setLocation(one.getX(), newy1);
            two.setLocation(two.getX(), newy2);
            thr.setLocation(thr.getX(), newy3);
            fou.setLocation(fou.getX(), newy4);
            return true;
        }

        board.placePiece(this);

        return false;
    }

}

package ui.model;

import java.awt.*;

public class PieceProxy implements Animatable {

    private Animatable piece;

    public void setPiece(Animatable p) {
        piece = p;
    }

    public void fill(Graphics2D brush) {
        piece.fill(brush);
    }

    public void draw(Graphics2D brush) {
        piece.draw(brush);
    }

    //public boolean moveUp() {
    //    return piece.moveUp();
    //}

    public boolean moveDown() {
        return piece.moveDown();
    }

    public boolean moveLeft() {
        return piece.moveLeft();
    }

    public boolean moveRight() {
        return piece.moveRight();
    }

    /*public boolean turnLeft() {
        return piece.turnLeft();
    }

    public boolean turnRight() {
        return piece.turnRight();
    }*/
    
}

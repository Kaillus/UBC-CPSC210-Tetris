package model.paint;

import java.awt.*;

public class Square extends SmartRectangle {
    private int xpos;
    private int ypos;
    private java.awt.Color borderColour;
    private java.awt.Color fillColour;
    private int rotation;
    private final int strokeWidth = 2;

    //MODIFIES: this
    //EFFECTS: creates a Square with a colour (if empty, colour is empty), and x/y coordinates
    public Square(Color colour, int x, int y) {
        super(colour);
        //this.dimensions = dimensions;
        this.xpos = x;
        this.ypos = y;
        //System.out.println("Square!");
        this.borderColour = colour;
        this.fillColour = colour; // solid colour to start
        this.rotation = 0;
    }

    public Square(Color colour) {
        super(colour);
        //this.dimensions = dimensions;
        //System.out.println("Square!");
        this.borderColour = colour;
        this.fillColour = colour; // solid colour to start
        this.rotation = 0;
    }

    //EFFECTS: returns true if square is empty and false if not
    public boolean isEmpty() {
        return this.fillColour.equals(Color.black);
    }

    //EFFECTS: returns input square's colour
    public Color getColour() {
        return this.fillColour;
    }

    //MODIFIES: this
    //EFFECTS: sets square colour to input colour
    public void setColour(Color colour) {
        this.fillColour = colour;
    }

    //EFFECTS: returns input square's x
    public int getSquareX() {
        return this.xpos;
    }

    //EFFECTS: returns input square's y
    public int getSquareY() {
        return this.ypos;
    }

    //MODIFIES: this
    //EFFECTS: sets a Square's position on the grid
    public void setPosition(int x, int y) {
        this.xpos = x;
        this.ypos = y;
    }

}
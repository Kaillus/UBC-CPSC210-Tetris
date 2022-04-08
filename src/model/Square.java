package model;

import java.util.ArrayList;

public class Square {
    //private int dimensions;
    private String colour;
    private boolean empty;
    private int x;
    private int y;

    //MODIFIES: this
    //EFFECTS: creates a Square with boolean empty?, a colour, and x/y coordinates
    public Square(boolean empty, String colour, int x, int y) {
        //this.dimensions = dimensions;
        this.empty = empty;
        this.colour = colour;
        this.x = x;
        this.y = y;
        //System.out.println("Square!");
    }

    //EFFECTS: returns true if square is empty and false if not
    public boolean isEmpty() {
        return this.empty;
    }

    //MODIFIES: this
    //EFFECTS: flips empty's boolean state
    public void switchEmpty() {
        this.empty = !this.empty;
    }

    //EFFECTS: returns input square's colour
    public String getColour() {
        return this.colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    //EFFECTS: returns input square's x
    public int getX() {
        return this.x;
    }

    //EFFECTS: returns input square's y
    public int getY() {
        return this.y;
    }

    //MODIFIES: this
    //EFFECTS: sets a Square's position on the grid
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //EFFECTS: returns input square's ordered coordinate pair on the grid
//    public HashMap<> getPosition(Square square) {
//        return
//    }

}
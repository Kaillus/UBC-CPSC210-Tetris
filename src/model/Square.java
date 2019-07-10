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
    public static boolean isEmpty(Square square) {
        return square.empty;
    }

    public void switchEmpty() {
        this.empty = !this.empty;
    }

    //EFFECTS: returns input square's colour
    public static String getColour(Square square) {
        return square.colour;
    }

    //EFFECTS: returns input square's x
    public static int getX(Square square) {
        return square.x;
    }

    //EFFECTS: returns input square's y
    public static int getY(Square square) {
        return square.y;
    }

    //EFFECTS: returns input square's ordered coordinate pair on the grid
//    public HashMap<> getPosition(Square square) {
//        return
//    }

}
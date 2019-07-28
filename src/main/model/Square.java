package model;

public class Square {

    private String colour;
    private int xpos;
    private int ypos;

    //MODIFIES: this
    //EFFECTS: creates a Square with a colour (if empty, colour is empty), and x/y coordinates
    public Square(String colour, int x, int y) {
        //this.dimensions = dimensions;
        this.colour = colour;
        this.xpos = x;
        this.ypos = y;
        //System.out.println("Square!");
    }

    //EFFECTS: returns true if square is empty and false if not
    public boolean isEmpty() {
        return this.colour.equals("black");
    }

    //EFFECTS: returns input square's colour
    public String getColour() {
        return this.colour;
    }

    //MODIFIES: this
    //EFFECTS: sets square colour to input colour
    public void setColour(String colour) {
        this.colour = colour;
    }

    //EFFECTS: returns input square's x
    public int getX() {
        return this.xpos;
    }

    //EFFECTS: returns input square's y
    public int getY() {
        return this.ypos;
    }

    //MODIFIES: this
    //EFFECTS: sets a Square's position on the grid
    public void setPosition(int x, int y) {
        this.xpos = x;
        this.ypos = y;
    }

}
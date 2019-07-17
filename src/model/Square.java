package model;

public class Square {

    private String colour;
    private int x;
    private int y;

    //MODIFIES: this
    //EFFECTS: creates a Square with a colour (if empty, colour is empty), and x/y coordinates
    public Square(String colour, int x, int y) {
        //this.dimensions = dimensions;
        this.colour = colour;
        this.x = x;
        this.y = y;
        //System.out.println("Square!");
    }

    //EFFECTS: returns true if square is empty and false if not
    public boolean isEmpty() {
        return (this.colour == "black");
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

}
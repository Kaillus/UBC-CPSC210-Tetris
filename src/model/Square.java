package model;

public class Square {
    //private int dimensions;
    private int dimensions = 5;
    private String colour;
    private boolean empty;
    private int x;
    private int y;

    public Square(String colour, boolean empty, int x, int y){
        //this.dimensions = dimensions;
        this.colour = colour;
        this.empty = empty;
        this.x = x;
        this.y = y;
        //System.out.println("Square!");
    }

    public boolean isEmpty(Square square) {
        return square.empty;
    }

}
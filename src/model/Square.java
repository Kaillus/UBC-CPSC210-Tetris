package model;

public class Square {
    private int dimensions;
    private String colour;

    public Square(int dimensions, String colour){
        this.dimensions = dimensions;
        this.colour = colour;

        System.out.println("Square!");
    }

    public static void squareDimensions(Square square){
        System.out.println("This square's dimensions are " + square.dimensions + "x" + square.dimensions);
    }

    public static void squareColour(Square square){
        System.out.println("This square's colour is " + square.colour);
    }
    public Square() {}
}
package ui;

import model.Square;
//import model.Tetramino;

public class Main {
    public static void main(String[] args) {
        //Square Blue100 = new Square();
        //Blue100.dimensions = 100;
        //Blue100.colour = "blue";
        Square Blue100 = new Square(100, "blue");

        Square.squareDimensions(Blue100);
        Square.squareColour(Blue100);

        System.out.println("main!");
    }
}
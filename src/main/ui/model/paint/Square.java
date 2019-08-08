package ui.model.paint;

import java.awt.*;

public class Square extends java.awt.geom.Rectangle2D.Double {
    private java.awt.Color borderColour;
    private java.awt.Color fillColour;
    private int rotation;
    private final int strokeWidth = 0;

    public Square(Color colour) {
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
    public void setFillColour(Color colour) {
        this.fillColour = colour;
    }

    // methods not provided by Java
    public void setBorderColour(java.awt.Color colour) {
        this.borderColour = colour;
    }

    public void setColor(java.awt.Color colour) {
        this.borderColour = colour;
        this.fillColour = colour;
    }

    public void setRotation(int rotation) {
        this.rotation = rotation;
    }

    // more readable versions of methods provided by Java
    public void setLocation(double x, double y) {
        this.setFrame(x, y, this.getWidth(), this.getHeight());
    }

    public void setSize(int width, int height) {
        this.setFrame(this.getX(), this.getY(), width, height);
    }

    // not provided by Java
    public void fill(java.awt.Graphics2D brush) {
        java.awt.Color oldColour = brush.getColor();
        brush.setColor(fillColour);
        brush.fill(this);
        brush.setColor(oldColour);
    }

    public void draw(java.awt.Graphics2D brush) {
        java.awt.Color oldColour = brush.getColor();
        brush.setColor(borderColour);
        java.awt.Stroke oldStroke = brush.getStroke();
        brush.setStroke(new java.awt.BasicStroke(strokeWidth));
        brush.draw(this);
        brush.setStroke(oldStroke);
        brush.setColor(oldColour);
    }

    //MODIFIES: this
    //EFFECTS: sets a Square's position on the grid
    public void setPosition(int x, int y) {
        this.setFrame(x, y, this.getWidth(), this.getHeight());
    }

}
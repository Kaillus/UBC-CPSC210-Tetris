package ui.model.pieces;

public class SmartRectangle extends java.awt.geom.Rectangle2D.Double {
    private java.awt.Color borderColour;
    private java.awt.Color fillColour;
    private int rotation;
    private final int strokeWidth = 2;

    public SmartRectangle(java.awt.Color colour) {
        borderColour = colour;
        fillColour = colour; // solid colour to start
        rotation = 0;
    }

    // methods not provided by Java
    public void setBorderColour(java.awt.Color colour) {
        borderColour = colour;
    }

    public void setFillColour(java.awt.Color colour) {
        fillColour = colour;
    }

    public void setColor(java.awt.Color colour) {
        borderColour = colour;
        fillColour = colour;
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
}
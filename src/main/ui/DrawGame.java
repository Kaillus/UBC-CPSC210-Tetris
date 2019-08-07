package ui;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import logic.Game;
import model.PieceProxy;
import model.paint.Paintable;
import model.paint.Square;

import static ui.Constants.UIFrame;

public class DrawGame {

    /*private Game game;
    private PieceProxy proxy;


    @Override
    public void background() {
        JPanel panel = populatePanel();
        panel.setBackground(Color.black);
        panel.setOpaque(false);
        Dimension size = new Dimension(512, 430);
        panel.setPreferredSize(size);
        UIFrame.getContentPane().add(panel);

    }

    @Override
    public void update() {
        game.getGameBoard().updatePiece(game.getGameBoard().getCurrentPiece());
    }

    @Override
    public void draw() {
        background();
        pack();
    }

    @Override
    public void init() {
        game = new Game();
        draw();
        //keyListening();
    }*/

}

package ui;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import logic.Game;
import model.paint.Paintable;
import model.paint.Square;

import static ui.Constants.UIFrame;

public class DrawGame extends DrawPack implements DrawState {

    private Game game;

    private JPanel populatePanel() {
        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(java.awt.Graphics brush) {
                super.paintComponent(brush);
                java.awt.Graphics2D betterBrush = (java.awt.Graphics2D) brush;

                // put the current piece on the board
                game.getGameBoard().getCurrentPiece().fill(betterBrush);
                game.getGameBoard().getCurrentPiece().draw(betterBrush);
                // Put all other blocks on the board
                for (int i = 0; i < game.getGameBoard().getBoardWidth(); i++) {
                    for (int j = 0; j < game.getGameBoard().getBoardHeight(); j++) {
                        Square block = game.getGameBoard().getBoardState()[j][i];
                        if (block != null) {
                            block.draw(betterBrush);
                            block.fill(betterBrush);
                        }
                    }
                }
            }
        };
        return panel;
    }

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
    }

}

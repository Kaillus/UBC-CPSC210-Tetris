package ui;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import logic.Game;

import static ui.Constants.UIFrame;

public class DrawGame extends DrawPack implements DrawState {

    private Game game;

    @Override
    public void background() {
        try {
            BufferedImage bg = ImageIO.read(new File("src/main/assets/TetrisLogo.png"));
            JPanel panel = new JPanel() {
                @Override
                protected void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.drawImage(bg, 0, 0, null);
                }
            };
            panel.setOpaque(false);
            Dimension size = new Dimension(250,163);
            panel.setPreferredSize(size);
            UIFrame.getContentPane().add(panel);
        } catch (IOException e) {
            System.out.println("Image retrieval failed");
            System.exit(1);
        }
    }

    @Override
    public void update() {
        game.gameBoard.updatePiece(game.gameBoard.getCurrentPiece());
    }

    @Override
    public void draw()  {
        background();
        pack();
    }

    @Override
    public void init() {
        draw();
        Game game = new Game();
        game.init();
        //keyListening();
    }

}

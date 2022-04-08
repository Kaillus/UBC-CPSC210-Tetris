/*

Contains full code used for drawing states that was repetitively called in each state's draw methods

*/

package ui;

import logic.KeyInput;

import javax.swing.*;

import java.awt.event.KeyListener;

import static logic.Constants.TetrisFrame;

public abstract class DrawPack {

    public abstract void background();

    void pack() {
        KeyListener keyListener = new KeyInput();
        TetrisFrame.addKeyListener(keyListener);

        TetrisFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        TetrisFrame.setResizable(false);
        TetrisFrame.setFocusable(true);
        TetrisFrame.pack();
        TetrisFrame.setLocationRelativeTo(null);
        TetrisFrame.setVisible(true);
    }

    protected static void shutdown() {
        TetrisFrame.removeAll();
        TetrisFrame.repaint();
        TetrisFrame.revalidate();
    }

}

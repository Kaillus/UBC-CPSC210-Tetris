/*

Contains full code used for drawing states that was repetitively called in each state's draw methods

*/

package ui;

import logic.KeyInputUI;

import javax.swing.*;

import java.awt.event.KeyListener;

import static logic.Constants.UIFrame;

public abstract class DrawPack {

    public abstract void background();

    void pack() {
        KeyListener keyListener = new KeyInputUI();
        UIFrame.addKeyListener(keyListener);

        UIFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        UIFrame.setResizable(false);
        UIFrame.setFocusable(true);
        UIFrame.pack();
        UIFrame.setLocationRelativeTo(null);
        UIFrame.setVisible(true);
    }

    protected static void shutdown() {
        UIFrame.removeAll();
        UIFrame.repaint();
        UIFrame.revalidate();
    }

}

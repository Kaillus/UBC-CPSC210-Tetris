/*

Contains full code used for drawing states that was repetitively called in each state's draw methods

*/

package ui;

import javax.swing.*;

import java.awt.event.KeyListener;

import static ui.Constants.UIFrame;

public abstract class DrawPack {

    public abstract void background();

    void pack() {
        UIFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        UIFrame.setResizable(false);
        UIFrame.setFocusable(true);
        UIFrame.pack();
        UIFrame.setLocationRelativeTo(null);
        UIFrame.revalidate();
        UIFrame.repaint();
        UIFrame.setVisible(true);
    }

    protected static void shutdown() {
        UIFrame.getContentPane().removeAll();
        UIFrame.invalidate();
    }

}

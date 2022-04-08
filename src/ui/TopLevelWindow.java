package ui;

import javax.swing.*;
import java.awt.*;

// Create GUI
public class TopLevelWindow {
    public static void createWindow() {
        JFrame frame = new JFrame("Not Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel background = new JLabel();
        frame.getContentPane().add(background, BorderLayout.CENTER);
        background.setPreferredSize(new Dimension(500, 500));
        background.setOpaque(true);


        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
}

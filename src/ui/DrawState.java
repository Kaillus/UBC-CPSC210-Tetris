/*

Draws UI on screen appropriate to current state

 */


package ui;

//import static logic.State.States.MENU;
//import static logic.State.States.GAME;
//import static logic.State.States.MENU;
//import static logic.State.States.MENU;


//import logic.State;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class DrawState {

    public static void DrawMenu() {
        JFrame frame = new JFrame("Not Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        String iconPath = "src/image/menu.png";
        ImageIcon icon = new ImageIcon(iconPath);
        JLabel iconLabel = new JLabel(icon);
        frame.getContentPane().add(new JScrollPane(iconLabel));
        iconLabel.setSize(250,163);
        iconLabel.setLocation(250,100);
        iconLabel.setOpaque(false);
        panel.add(iconLabel);

        frame.add(panel);

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.pack();
        frame.setVisible(true);
    }

    public static void DrawGame() {

        JFrame frame = new JFrame("Not Tetris");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        String iconPath = "src/image/TetrisLogo.png";
        ImageIcon icon = new ImageIcon(iconPath);
        JLabel iconLabel = new JLabel(icon);
        frame.getContentPane().add(new JScrollPane(iconLabel));
        iconLabel.setSize(250,163);
        iconLabel.setLocation(250,100);
        iconLabel.setOpaque(false);
        panel.add(iconLabel);

        frame.add(panel);

        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setFocusable(true);
        frame.pack();
        frame.setVisible(true);

    }

}
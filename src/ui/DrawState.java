/*

Draws UI on screen appropriate to current state

 */


package ui;

//import static logic.State.States.MENU;
//import static logic.State.States.GAME;
//import static logic.State.States.MENU;
//import static logic.State.States.MENU;


//import logic.State;

import logic.KeyInput;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

//import java.awt.Color;
//import java.awt.BorderLayout;
//import java.awt.Dimension;

/*public interface DrawState {
    void update();
    void draw();
    void keyListening();
}

class DrawMenu implements DrawState {

    @Override
    public void update() {
        //dab();
    }

    @Override
    public void draw()  {
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

    @Override
    public void keyListening() {
        //KeyListener listener = new KeyListener();

    }
}*/
public class DrawState {

    private static JFrame frame = new JFrame("Not Tetris");

    public static void DrawMenu() {
        //JFrame frame = new JFrame("Not Tetris");

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
        frame.setResizable(false);

        KeyListener keyListener = new KeyInput();
        frame.addKeyListener(keyListener);

        frame.setFocusable(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void DrawGame() {
        frame.removeAll();
        frame.revalidate();
        frame.repaint();

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

        //frame.setResizable(false);
        KeyListener keyListener = new KeyInput();
        frame.addKeyListener(keyListener);
        //frame.setFocusable(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
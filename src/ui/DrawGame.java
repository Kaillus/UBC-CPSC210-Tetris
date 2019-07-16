package ui;

import logic.KeyInput;

import javax.swing.*;
import java.awt.event.KeyListener;

import static logic.Constants.TetrisFrame;

public class DrawGame implements DrawState {

    //public static JFrame TetrisFrame = new JFrame("Not Tetris: Game");

    @Override
    public void update() {
        //TODO
    }

    @Override
    public void draw()  {
        TetrisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        String iconPath = "src/image/TetrisLogo.png";
        ImageIcon icon = new ImageIcon(iconPath);
        JLabel iconLabel = new JLabel(icon);
        TetrisFrame.getContentPane().add(new JScrollPane(iconLabel));
        iconLabel.setSize(250,163);
        iconLabel.setLocation(250,100);
        iconLabel.setOpaque(false);
        panel.add(iconLabel);

        KeyListener keyListener = new KeyInput();
        TetrisFrame.addKeyListener(keyListener);

        TetrisFrame.add(panel);
        TetrisFrame.setResizable(false);

        TetrisFrame.setFocusable(true);
        TetrisFrame.pack();
        TetrisFrame.setLocationRelativeTo(null);
        TetrisFrame.setVisible(true);
    }

    @Override
    public void init() {
        draw();
        //keyListening();
    }

}

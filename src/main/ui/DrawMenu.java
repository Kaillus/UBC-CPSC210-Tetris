package ui;

import javax.swing.*;

import static logic.Constants.TetrisFrame;

public class DrawMenu extends DrawPack implements DrawState {

    @Override
    public void background() {
        JPanel panel = new JPanel();
        String iconPath = "src/main/image/menu.png";
        ImageIcon icon = new ImageIcon(iconPath);
        JLabel iconLabel = new JLabel(icon);
        TetrisFrame.getContentPane().add(new JScrollPane(iconLabel));
        iconLabel.setSize(250,163);
        iconLabel.setLocation(250,100);
        iconLabel.setOpaque(false);
        panel.add(iconLabel);
        TetrisFrame.add(panel);
    }

    @Override
    public void update() {
        // no updating on menu screen
    }

    @Override
    public void draw()  {
        background();
        pack();
    }

    @Override
    public void init() {
        draw();
        //keyListening();
    }

}

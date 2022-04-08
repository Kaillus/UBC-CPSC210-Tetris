package ui;

import javax.swing.*;

import java.awt.*;

import static logic.Constants.UIFrame;

public class DrawMenu extends DrawPack implements DrawState {

    @Override
    public void background() {
        JPanel panel = new JPanel();
        String iconPath = "src/main/assets/menu.png";
        ImageIcon icon = new ImageIcon(iconPath);
        JLabel iconLabel = new JLabel(icon);
        UIFrame.getContentPane().add(new JScrollPane(iconLabel));
        Dimension size = new Dimension(512,430);
        iconLabel.setPreferredSize(size);
        //iconLabel.setLocation(250,100);
        iconLabel.setOpaque(false);
        panel.add(iconLabel);
        UIFrame.getContentPane().add(panel);
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

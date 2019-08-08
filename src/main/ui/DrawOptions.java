package ui;

import model.TetrisProperties;

import javax.swing.*;

import java.io.IOException;

import static ui.Constants.UIFrame;

public class DrawOptions implements DrawState {

    public DrawOptions() {
        draw();
    }

    @Override
    public void update() {
        // no updating on options screen
    }

    @Override
    public void draw()  {
        JSlider slider = drawSlider();
        int optionPanel = JOptionPane.showOptionDialog(
                UIFrame,
                slider,
                "Set game speed",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, null, null);
        if (JOptionPane.OK_OPTION == optionPanel) {
            try {
                TetrisProperties.writeToProperties(slider.getValue(), "config.properties");
            } catch (IOException e) {
                System.out.println("IOException was thrown writing options slider to properties");
            }
            Constants.getInstance().setGameSpeed(slider.getValue());
        } else {
            System.out.println("gameSpeed was not set (cancel button?)");
        }
    }

    private static JSlider drawSlider() {
        JSlider slider = new JSlider(1,10);
        slider.setMaximum(10);
        slider.setMinimum(1);
        slider.setValue(Constants.getInstance().getGameSpeed());
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        return slider;
    }


}

package ui;

import logic.Constants;
import logic.TetrisProperties;

import javax.swing.*;

import static logic.Constants.TetrisFrame;

public class DrawOptions implements DrawState {

    @Override
    public void update() {
        // no updating on options screen
    }

    @Override
    public void draw()  {
        JSlider slider = drawSlider();
        int optionPanel = JOptionPane.showOptionDialog(
                TetrisFrame,
                slider,
                "Set game speed",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, null, null);
        if (JOptionPane.OK_OPTION == optionPanel) {
            TetrisProperties.writeToProperties(slider.getValue(), "config.properties");
            Constants.setGameSpeed(slider.getValue());
        } else {
            System.out.println("gameSpeed was not set (cancel button?)");
        }
    }

    private static JSlider drawSlider() {
        JSlider slider = new JSlider(1,10);
        slider.setMaximum(10);
        slider.setMinimum(1);
        slider.setValue(Constants.getGameSpeed());
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setSnapToTicks(true);
        return slider;
    }

    @Override
    public void init() {
        draw();
    }


}

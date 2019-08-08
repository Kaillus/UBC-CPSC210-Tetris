package ui;

import logic.TetrisProperties;
import ui.logic.State;

import javax.swing.*;
import java.io.IOException;

import static ui.Constants.UIFrame;
import static ui.logic.State.States.GAME;

public class DrawGameOver implements DrawState {

    public DrawGameOver() {
        draw();
    }

    @Override
    public void update() {
        // no updating on options screen
    }

    @Override
    public void draw()  {
        int optionPanel = JOptionPane.showOptionDialog(
                UIFrame,
                "You lost! Play again?",
                "Game over!",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null, null, null);
        if (JOptionPane.OK_OPTION == optionPanel) {
            State.getInstance().switchState(GAME);
        } else {
            System.exit(0);
        }
    }
}

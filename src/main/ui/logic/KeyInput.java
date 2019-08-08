/*

Handles actions that occur based on user key input

 */

package ui.logic;

import ui.DrawOptions;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static ui.logic.State.States.GAME;
//import static ui.model.State.States.PAUSE;
//import static ui.model.State.States.MENU;

public class KeyInput extends KeyAdapter {

    private State state = State.getInstance();

    public KeyInput() {
        super();
    }

    //MODIFIES: State
    //EFFECTS: Handles key input
    //         Enter at MENU advances game to state GAME
    //         Escape at any state closes the window
    //         Backspace at MENU opens OPTIONS window
    //         Shift at GAME to save current block
    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_ESCAPE) {
            System.out.println("Exiting process via emergency escape, currentState was: " + state.getState());
            System.exit(0);
        }

        switch (state.getState()) {

            case MENU:
                keyPressedInMenu(e);
                break;

            case GAME:
                //keyPressedInGame(e);
                break;

            default:
                break;

        }

    }

    private void keyPressedInMenu(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            state.switchState(GAME);
        }

        if (keyCode == KeyEvent.VK_BACK_SPACE) {
            DrawOptions drawOptions = new DrawOptions();
        }

    }


}
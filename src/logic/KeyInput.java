/*

Handles actions that occur based on user key input

 */

package logic;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static logic.State.States.MENU;
import static logic.State.States.GAME;
//import static logic.State.States.PAUSE;
//import static logic.State.States.MENU;

public class KeyInput extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            if (State.getState() == MENU) {
                State.switchState(GAME);
            }
        }

        if (keyCode == KeyEvent.VK_ESCAPE) {
            System.out.println("Exiting process via emergency escape, currentState was: " + State.getState());
            System.exit(0);
        }

    }

}
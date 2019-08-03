/*

Handles actions that occur based on user key input

 */

package logic;

import com.sun.org.apache.bcel.internal.classfile.Unknown;
import logic.java.UnknownStateException;
import ui.DrawOptions;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static logic.State.States.MENU;
import static logic.State.States.GAME;
//import static logic.State.States.PAUSE;
//import static logic.State.States.MENU;

public class KeyInputUI extends KeyAdapter implements java.io.Closeable, logic.java.Printer {

    //EFFECTS: closes window and kills process
    @Override
    public void close() {
        System.exit(0);
    }

    //EFFECTS: prints input string to internal console
    @Override
    public void print(String string) {
        System.out.println(string);
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
            print("Exiting process via emergency escape, currentState was: " + State.getState());
            close();
        }

        switch (State.getState()) {

            case MENU:
                keyPressedInMenu(e);
                break;

            case GAME:
                keyPressedInGame(e);
                break;

            default:
                break;

        }

    }

    private void keyPressedInMenu(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            State.switchState(GAME);
        }

        if (keyCode == KeyEvent.VK_BACK_SPACE) {
            DrawOptions drawOptions = new DrawOptions();
            drawOptions.draw();
        }

    }

    private void keyPressedInGame(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_SHIFT) {
            //Game.saveBlock();
        }


    }


}
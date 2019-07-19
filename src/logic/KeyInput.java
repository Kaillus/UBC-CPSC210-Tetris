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

public class KeyInput extends KeyAdapter implements java.io.Closeable, logic.java.Printer  {

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
    @Override
    public void keyPressed(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (State.getState() == MENU) {
            keyPressedInMenu(e);
        }

        if (keyCode == KeyEvent.VK_ESCAPE) {
            print("Exiting process via emergency escape, currentState was: " + State.getState());
            close();
        }

    }

    private void keyPressedInMenu(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_ENTER) {
            try {
                State.switchState(GAME);
            } catch (UnknownStateException s) {
                System.out.println("Game state switch failed");
                close();
            }
        }

        if (keyCode == KeyEvent.VK_BACK_SPACE) {
            DrawOptions drawOptions = new DrawOptions();
            drawOptions.draw();
        }

    }

}
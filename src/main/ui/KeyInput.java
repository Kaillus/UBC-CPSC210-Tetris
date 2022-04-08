/*

Handles actions that occur based on user key input

 */

package ui;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static ui.State.States.GAME;
//import static ui.State.States.PAUSE;
//import static ui.State.States.MENU;

public class KeyInput extends KeyAdapter implements java.io.Closeable, logic.java.Printer {

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
            print("Exiting process via emergency escape, currentState was: " + state.getState());
            close();
        }

        switch (state.getState()) {

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
            state.switchState(GAME);
        }

        if (keyCode == KeyEvent.VK_BACK_SPACE) {
            DrawOptions drawOptions = new DrawOptions();
            drawOptions.draw();
        }

    }

    private void keyPressedInGame(KeyEvent e) {

        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_X) {
            //Game.saveBlock();
        }

        if (keyCode == KeyEvent.VK_Z) {
            //Game.rotatePiece(piece, 1)
        }

        if (keyCode == KeyEvent.VK_C) {
            //Game.rotatePiece(piece, 2)
        }

        if (keyCode == KeyEvent.VK_DOWN) {
            //Game.movePiece(piece?, 1)
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            //Game.movePiece(piece?, 2)
        }

        if (keyCode == KeyEvent.VK_RIGHT) {
            //Game.movePiece(piece?, 3)
        }

        if (keyCode == KeyEvent.VK_SPACE) {
            //Game.fastFallPiece(piece)
        }



    }


}
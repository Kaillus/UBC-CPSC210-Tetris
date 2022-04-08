/*

Handles actions that occur based on user key input

 */

package ui.logic;

import model.Game;
import ui.DrawOptions;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static java.awt.event.KeyEvent.VK_TAB;
import static ui.logic.State.States.GAME;
import static ui.logic.State.States.GAME_OVER;
//import static ui.model.State.States.PAUSE;
//import static ui.model.State.States.MENU;

public class KeyInput extends KeyAdapter {

    private State state = State.getInstance();

    private Board gameBoard = Game.getInstance().getGameBoard();

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
        }

    }

    private void keyPressedInGame(KeyEvent e) {

        int keyCode = e.getKeyCode();


        if (keyCode == KeyEvent.VK_Z) {
            Game.getInstance().getGameBoard().getProxy().turnLeft();
            Game.getInstance().getGameBoard().repaintBoard();
        }

        if ((keyCode == KeyEvent.VK_C) || (keyCode == KeyEvent.VK_UP)) {
            Game.getInstance().getGameBoard().getProxy().turnRight();
            Game.getInstance().getGameBoard().repaintBoard();
        }

        if (keyCode == KeyEvent.VK_TAB) {
            pause();
        }

        directionalKeys(e);
    }

    private void directionalKeys(KeyEvent e) {

        int keyCode = e.getKeyCode();


        if (keyCode == KeyEvent.VK_RIGHT) {
            Game.getInstance().getGameBoard().getProxy().moveRight();
            Game.getInstance().getGameBoard().repaintBoard();
        }

        if (keyCode == KeyEvent.VK_LEFT) {
            Game.getInstance().getGameBoard().getProxy().moveLeft();
            Game.getInstance().getGameBoard().repaintBoard();
        }

        if (keyCode == KeyEvent.VK_DOWN) {
            Game.getInstance().getGameBoard().getProxy().moveDown();
            Game.getInstance().getGameBoard().repaintBoard();
        }
    }

    private void pause() {
        if (gameBoard.getTimer().isRunning()) {
            gameBoard.getTimer().stop();
            gameBoard.setPause(true);
        } else {
            if (!(State.getInstance().getState() == GAME_OVER)) {
                gameBoard.getTimer().start();
                gameBoard.setPause(false);
            }
        }
    }


}
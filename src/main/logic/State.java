/*

Creates game states and triggers for changing game states

Debug: currentState

 */

package logic;

import logic.java.UnknownStateException;
import ui.DrawGame;
import ui.DrawMenu;
import ui.DrawPack;
import ui.DrawState;

import static logic.State.States.MENU;

public class State extends DrawPack {

    public enum States {
        MENU, GAME, PAUSE, GAME_OVER, debug
    }

    private States currentState;

    private States previousState;

    private static final State INSTANCE = new State();

    private State() {
    }

    public static State getInstance() {
        return INSTANCE;
    }

    //REQUIRES: currentState initialized
    //EFFECTS: returns currentState
    public States getState() {
        //System.out.println("State is currently: " + currentState);
        return currentState;
    }

    //MODIFIES: this
    //EFFECTS: sets currentState to input state
    public void setState(States newState) {
        currentState = newState;
        System.out.println("State is now: " + currentState);
    }

    //MODIFIES: this
    //EFFECTS: changes currentState to input state and initializes associated game mode and methods
    public void switchState(States switchToState) {
        previousState = currentState;
        setState(switchToState);
        switch (currentState) {
            case MENU:
                stateDrawMenu();
                break;

            case GAME:
                stateDrawGame();
                break;

            case PAUSE:
                //call UI to draw PAUSE
                break;

            case GAME_OVER:
                //call UI to draw GAME_OVER
                break;

            default:
                throwDebugFail();

        }
    }

    private void stateDrawMenu() {
        DrawState drawMenu = new DrawMenu();
        drawMenu.init();
    }

    private void stateDrawGame() {
        //shutdown();
        DrawState drawGame = new DrawGame();
        drawGame.init();
    }

    private void throwDebugFail() {
        try {
            throw new UnknownStateException();
        } catch (UnknownStateException e) {
            System.out.println("UnknownStateException! State changed to illegal state " + currentState);
            setState(previousState);
            System.out.println("Reverting state to previous state " + previousState);
        } finally {
            System.out.println("State was changed to: " + currentState);
        }
    }


    @Override
    public void background() {
    }

}

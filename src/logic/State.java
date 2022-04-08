/*

Creates game states and triggers for changing game states

Debug: currentState

 */

package logic;

import ui.DrawGame;
import ui.DrawMenu;
import ui.DrawPack;
import ui.DrawState;

import static logic.State.States.MENU;

public class State extends DrawPack {

    public enum States {
        MENU, GAME, PAUSE, GAME_OVER
    }

    private static States currentState;

    //REQUIRES: currentState initialized
    //EFFECTS: returns currentState
    public static States getState() {
        //System.out.println("State is currently: " + currentState);
        return currentState;
    }

    //MODIFIES: this
    //EFFECTS: sets currentState to input state
    public static void setState(States newState) {
        currentState = newState;
        System.out.println("State is now: " + currentState);
    }

    //MODIFIES: this
    //EFFECTS: changes currentState to input state and initializes associated game mode and methods
    public static void switchState(States switchToState) {
        setState(switchToState);
        switch (currentState) {
            case MENU:
                DrawState drawMenu = new DrawMenu();
                drawMenu.draw();
                break;

            case GAME:
                shutdown();
                DrawState drawGame = new DrawGame();
                drawGame.draw();
                break;

            case PAUSE:
                //call UI to draw PAUSE
                break;

            case GAME_OVER:
                //call UI to draw GAME_OVER
                break;

            default:
                //System.out.println("UH OH " + currentState);
                break;
        }
    }



    @Override
    public void background() {
    }

}

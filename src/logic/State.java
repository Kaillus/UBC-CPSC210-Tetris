/*

Creates game states and triggers for changing game states

 */

package logic;

import ui.DrawState;

public class State {

    public enum States {
        MENU, GAME, PAUSE, GAME_OVER;
    }

    public static States currentState;

    public static void setState(States newState) {
        currentState = newState;
    }

    public static void switchState(States state) {
        setState(state);
        switch (currentState) {
            case MENU:
                ui.DrawState.DrawMenu();
                System.out.println("MENU");
                break;

            case GAME:
                ui.DrawState.DrawGame();
                System.out.println("GAME");
                break;

            case PAUSE:
                //call UI to draw PAUSE
                System.out.println("PAUSE");
                break;

            case GAME_OVER:
                //call UI to draw GAME_OVER
                System.out.println("GAME_OVER");
                break;

            default:
                System.out.println("UH OH");
                break;
        }
    }

}

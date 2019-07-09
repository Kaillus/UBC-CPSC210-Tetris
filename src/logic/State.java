/*

Creates game states and triggers for changing game states

Debug: currentState

 */

package logic;

import ui.DrawState;

import java.util.Map;
import java.util.HashMap;

public class State {

    public enum States {
        MENU, GAME, PAUSE, GAME_OVER
    }

    private static States currentState;

    /*private Map<States, DrawState> drawList = new HashMap<>();

    public void addState(States state, DrawState drawState) {
        drawList.put(state, drawState);
    }

    public void initState() {
        DrawState drawState = drawList.get(currentState);
        drawState.keyListening();
        drawState.update();
        drawState.draw();
    }*/

    public static States getState() {
        System.out.println("State is currently: " + currentState);
        return currentState;
    }

    public static void setState(States newState) {
        currentState = newState;
        System.out.println("State is now: " + currentState);
    }

    public static void switchState(States switchToState) {
        setState(switchToState);
        switch (currentState) {
            case MENU:
                ui.DrawState.DrawMenu();
                //initState();
                System.out.println("Drawing MENU");
                break;

            case GAME:
                ui.DrawState.DrawGame();
                System.out.println("Drawing GAME");
                break;

            case PAUSE:
                //call UI to draw PAUSE
                System.out.println("Drawing PAUSE");
                break;

            case GAME_OVER:
                //call UI to draw GAME_OVER
                System.out.println("Drawing GAME_OVER");
                break;

            default:
                System.out.println("UH OH " + currentState);
                break;
        }
    }

}

/*

Main class for main stuff

 */

package ui;

import logic.State;

import static logic.State.States.MENU;
import model.Square;
//import model.Tetramino;
//import logic.RandNext;

public class Main {

    Square blueAtOrigin = new Square(false,"blue",0,0);

    //MODIFIES: State
    //EFFECTS: initializes game by switching State to MENU and drawing menu
    private void initMenu() {
        //State.setState(MENU);

        State newState = new State();
        newState.switchState(MENU);
    }

    //EFFECTS: ditto ^
    public static void main(String[] args) {
        // initialize UI
        System.out.println("Main: Initializing UI");

        Main start = new Main();
        start.initMenu();
    }
}
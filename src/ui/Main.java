/*

Main class for main stuff

 */

package ui;

import logic.State;
import logic.Constants;

import static logic.State.States.MENU;
import model.Square;
//import model.pieces.LPiece;
//import logic.RandNext;

public class Main {

    //MODIFIES: State
    //EFFECTS: initializes game by switching State to MENU and drawing menu
    private static void initMenu() {
        Constants.initConstants();
        State.switchState(MENU);
    }

    //EFFECTS: ditto ^
    public static void main(String[] args) {
        // initialize UI
        System.out.println("Main: Initializing UI");
        initMenu();
    }
}
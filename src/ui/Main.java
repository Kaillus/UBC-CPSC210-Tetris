/*

Main class for main stuff

 */

package ui;

import logic.State;

import static logic.State.States.MENU;
import model.Square;
//import model.Tetramino;
//import logic.randNext;

public class Main {

    Square Blue00 = new Square("blue",false,0,0);

    private static void initMenu() {
        //State.setState(MENU);
        State.switchState(MENU);
    }

    public static void main(String[] args) {
        // initialize UI
        System.out.println("Main: Initializing UI");

        initMenu();
    }
}
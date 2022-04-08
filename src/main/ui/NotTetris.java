/*

Main class for main stuff

 */

package ui;

import static ui.State.States.MENU;

public class NotTetris {

    public static void main(String[] args) {
        // initialize UI
        System.out.println("NotTetris: Initializing UI");
        Constants.getInstance().initConstants("config.properties");
        State.getInstance().switchState(MENU);
    }
}
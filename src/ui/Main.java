package ui;

import logic.State;

import static logic.State.States.MENU;
//import model.Tetramino;
//import logic.randNext;

public class Main {

    public static void initMenu() {
        State.setState(MENU);
        State.switchState(MENU);
    }


    public static void main(String[] args) {
        // initialize UI
        initMenu();
    }
}
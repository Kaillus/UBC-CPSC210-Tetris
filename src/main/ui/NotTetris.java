/*

Main class for main stuff

 */

package ui;

import com.sun.org.apache.bcel.internal.classfile.Unknown;
import logic.State;
import logic.Constants;

import static logic.State.States.MENU;

import logic.java.UnknownStateException;
import model.Square;

import javax.swing.*;
import java.awt.*;
//import model.pieces.LPiece;
//import logic.RandNext;

public class NotTetris {

    //MODIFIES: State
    //EFFECTS: initializes game by switching State to MENU and drawing menu
    private static void initMenu() {
        Constants.initConstants("config.properties");
        State.switchState(MENU);
    }

    //EFFECTS: ditto ^
    public static void main(String[] args) {
        // initialize UI
        System.out.println("NotTetris: Initializing UI");
        initMenu();
    }
}
/*

Supposed to handle global constants but there's only one I need to be global right now

*/

package logic;

import ui.ReadWebPageEx;

import javax.swing.*;
import java.io.File;

public final class Constants {

    public static JFrame UIFrame = new JFrame(ReadWebPageEx.fetchString());

    public static int gameSpeed;

    private static final Constants INSTANCE = new Constants();

    private Constants() {
    }

    public static Constants getInstance() {
        return INSTANCE;
    }

    //MODIFIES: this
    //EFFECTS: initializes global constants and default values
    public void initConstants(String configPath) {
        int initialSpeed = 1;

        File properties = new File(configPath);
        if (properties.isFile()) {
            gameSpeed = TetrisProperties.readFromProperties(configPath);
        } else {
            gameSpeed = initialSpeed;
            TetrisProperties.writeToProperties(initialSpeed, configPath);
        }
    }

    //EFFECTS: returns gameSpeed
    public int getGameSpeed() {
        return gameSpeed;
    }

    //EFFECTS: sets gameSpeed
    public void setGameSpeed(int i) {
        gameSpeed = i;
    }

}

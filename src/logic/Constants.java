/*

Supposed to handle global constants but there's only one I need to be global right now

*/

package logic;

import java.io.File;

public class Constants {

    public static int gameSpeed;
    private int initialSpeed = 1;

    //MODIFIES: this
    //EFFECTS: initializes global constants and default values
    public void initConstants() {

        File properties = new File("config.properties");
        if (properties.isFile()) {
            gameSpeed = TetrisProperties.readFromProperties();
        } else {
            gameSpeed = initialSpeed;
            TetrisProperties.writeToProperties(initialSpeed);
        }
    }

    //EFFECTS: returns gameSpeed
    public static int getGameSpeed() {
        return gameSpeed;
    }

    //EFFECTS: sets gameSpeed
    public static void setGameSpeed(int i) {
        gameSpeed = i;
    }

}

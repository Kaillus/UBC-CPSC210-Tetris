/*

Handles option popup internal file logic

!!!USES https://www.mkyong.com/java/java-properties-file-examples/ AS REFERENCE!!!

File handling code itself not written by me, only adapted to fit my project setup

*/

package logic;

import java.io.*;
import java.util.Properties;

public class TetrisProperties {

    //REQUIRES: p is a file path accessible from application root directory
    //MODIFIES: Constants
    //EFFECTS: writes input integer to properties file located at path p. if file doesn't exist, it is created
    public static void writeToProperties(int i, String p) {

        try (OutputStream output = new FileOutputStream(p)) {

            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("gameSpeed", Integer.toString(i));

            // save properties to project root folder
            prop.store(output, null);

            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }

    }

    //EFFECTS: reads stored values in properties file located at path p. if properties file at p does not exist,
    //         returns -1
    public static int readFromProperties(String p) {

        File properties = new File(p);
        if (!properties.isFile()) {
            System.out.println("File missing: couldn't read file at " + p);
            return -1;
        }

        try (InputStream input = new FileInputStream(p)) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            return Integer.parseInt(prop.getProperty("gameSpeed"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return 0;
    }


}

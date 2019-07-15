/*

Handles option popup internal file logic

!!!USES https://www.mkyong.com/java/java-properties-file-examples/ AS REFERENCE!!!

File handling code itself not written by me, only adapted to fit my project setup

*/

package logic;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class TetrisProperties {

    public static void writeToProperties(int i) {

        try (OutputStream output = new FileOutputStream("config.properties")) {

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

    public static int readFromProperties() {

        try (InputStream input = new FileInputStream("config.properties")) {

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

package tests;

import logic.Constants;
import logic.TetrisProperties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


public class TestConstants {

    /*private String testPath = "test.properties";
    Constants testConstants = new Constants();

    @BeforeEach
    public void deleteTestFile() {
        File testFile = new File(testPath);
        if (testFile.isFile()) {
            if (testFile.delete()) {
                System.out.println("Successfully cleared testFile");
            } else {
                System.out.println("Failed to delete testFile");
            }
        }
    }

    @Test
    public void testInit() {
        File testFile = new File(testPath);
        testConstants.initConstants(testPath);
        assertTrue(testFile.isFile());
        assertEquals(1, testConstants.getGameSpeed());
    }

    @Test
    public void testExistingInit() {
        File testFile = new File(testPath);
        TetrisProperties.writeToProperties(3,testPath);
        testConstants.initConstants(testPath);
        assertTrue(testFile.isFile());
        assertEquals(3, testConstants.getGameSpeed());
    }

    @Test
    public void testGetSet() {
        File testFile = new File(testPath);
        testConstants.initConstants(testPath);
        assertTrue(testFile.isFile());
        assertEquals(1, testConstants.getGameSpeed());
        testConstants.setGameSpeed(3);
        assertEquals(3, testConstants.getGameSpeed());
    }

    @Test
    public void testFrame() {
        assertTrue(testConstants.UIFrame instanceof JFrame);
    }

    @AfterEach
    public void deleteTestFile2() {
        deleteTestFile();
    }*/

}

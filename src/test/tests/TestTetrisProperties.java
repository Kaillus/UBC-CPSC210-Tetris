package tests;

import logic.TetrisProperties;
import org.junit.*;

import java.io.*;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class TestTetrisProperties {

    private String testPath = "test.properties";

    @Before
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
    public void testFirstRead() {
        assertEquals(-1, TetrisProperties.readFromProperties(testPath));
    }

    @Test
    public void testFirstWrite() {
        TetrisProperties.writeToProperties(5, testPath);
        File testFile = new File(testPath);
        assertTrue(testFile.isFile());
        assertEquals(5, TetrisProperties.readFromProperties(testPath));

    }

    @Test
    public void testMultipleWrite() {
        TetrisProperties.writeToProperties(8, testPath);
        TetrisProperties.writeToProperties(54, testPath);
        TetrisProperties.writeToProperties(5, testPath);
        assertEquals(5, TetrisProperties.readFromProperties(testPath));
    }

    @After
    public void clearTestFile() {
        deleteTestFile();
    }

}

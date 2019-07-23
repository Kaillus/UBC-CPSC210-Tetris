package tests;

import logic.State;

import logic.TetrisProperties;
import logic.java.PropertiesMissingException;
import logic.java.UnknownStateException;
import org.junit.*;

import static junit.framework.TestCase.assertTrue;
import static logic.State.States.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TestState {

    private State state;

    @Before
    public void setup() {
        state = new State();
    }

    @Test
    public void testStateChange() {
        state.setState(MENU);
        assertEquals(state.getState(), MENU);
        state.setState(GAME);
        assertEquals(state.getState(), GAME);
        state.switchState(PAUSE);
        assertEquals(state.getState(), PAUSE);
        state.switchState(GAME_OVER);
        assertEquals(state.getState(), GAME_OVER);
    }

    @Test
    public void testIllegalState() {
        state.setState(MENU);
        assertEquals(state.getState(), MENU);

        try{
            state.switchState(debug);
        } catch (UnknownStateException e) {
            fail("Failed to handle UnknownStateException");
        }

        assertEquals(state.getState(), MENU);

    }

    @Test
    public void testMissingFile() {
        //TetrisProperties.readFromProperties("fail.txt");
        try {
            TetrisProperties.readFromProperties("fail.txt");
            fail("exception was not well-implemented");
        } catch (PropertiesMissingException e) {
            //
        }
    }

}

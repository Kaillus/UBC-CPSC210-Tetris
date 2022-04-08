package tests;

import logic.State;

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
        state.setState(PAUSE);
        assertEquals(state.getState(), PAUSE);
        state.setState(GAME_OVER);
        assertEquals(state.getState(), GAME_OVER);
    }

    @Test
    public void testIllegalState() {
        state.setState(MENU);
        assertEquals(state.getState(), MENU);

//        try{
//            state.setState(debug);
//        } catch (UnknownStateException e) {
//            fail("Failed to handle UnknownStateException");
//        }

        assertEquals(state.getState(), MENU);

    }
}

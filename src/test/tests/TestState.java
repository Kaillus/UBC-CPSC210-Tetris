package tests;

import logic.State;

import logic.TetrisProperties;
import logic.java.PropertiesMissingException;
import logic.java.UnknownStateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static logic.State.States.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestState {

    /*private State state;

    @BeforeEach
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

    }*/

}

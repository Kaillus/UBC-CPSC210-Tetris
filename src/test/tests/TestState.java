package tests;

import logic.java.UnknownStateException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ui.logic.State;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static ui.logic.State.States.*;

public class TestState {

    State state = State.getInstance();

    @Test
    public void testStateChange() {
        state.setState(MENU);
        assertEquals(state.getState(), MENU);
        state.setState(GAME);
        assertEquals(state.getState(), GAME);
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

}

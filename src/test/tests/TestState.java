package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class TestState {

    /*@BeforeEach
    public void setup() {
        //State.getInstance().setState(previousState);
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

    @AfterAll
    public void fix() {
        previousState = State.getInstance().getState();
    }*/

}

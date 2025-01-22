package e2e;

import ggj.event.model.User_Event;
import ggj.util.Log;
import org.junit.jupiter.api.Test;

import static ggj.event.build.Events.*;

public class TestSequence {

    @Test
    public void run(){
        Log.info("hey!");
        user(User_Event.MSG_SENT).with("My Message 1").fire();
        user(User_Event.MSG_SENT).with("My Message 2").fire();
        user(User_Event.MSG_SENT).with("My Message 3").fire();

    }
}

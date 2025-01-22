package e2e;

import ggj.engine.EngineLauncher;
import ggj.event.model.User_Event;
import ggj.util.Log;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static ggj.event.build.Events.*;

public class TestSequence {
    @BeforeAll
    public static void setup() {
        EngineLauncher.launch();
    }

    @Test
    public void run() throws InterruptedException {
        Log.info("hey!");
        // stdKeysForType()
        user(User_Event.MSG_SENT).keys("userId", "Message").values(0, "My Message 1").fire();
        user(User_Event.MSG_SENT).keys("userId", "Message").values(0, "My Message 2").fire();
        user(User_Event.MSG_SENT).keys("userId", "Message").values(0, "My Message 3").fire();
        Thread.sleep(11100);
    }
}

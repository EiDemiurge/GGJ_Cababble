package event;

import ggj.event.model.User_Event;
import org.junit.jupiter.api.Test;

import static ggj.event.build.Events.user;

public class TestEventValidation {

    @Test
    public void run() throws InterruptedException {
        user(User_Event.MSG_SENT).keys("roomId", "Message").values(0, "My Message 1").fire();
    }
}
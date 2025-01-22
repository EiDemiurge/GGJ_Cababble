package ggj.event.model;

import ggj.event.build.Events;
import ggj.event.model.api.Event;
import ggj.event.model.api.EventType;

public enum User_Event implements EventType {
    MSG_SENT,
    RE_ROLL,
    ROOM_SWITCH,

;

    public record UserEvent(User_Event type, Events.EventArgs args) implements Event<User_Event> {

    }
}

package ggj.event.model;

import ggj.event.build.Events;
import ggj.event.model.api.Event;
import ggj.event.model.api.EventType;

public enum Engine_Event implements EventType {

    STAT_DELTA,
    ;

    public record EngineEvent(Engine_Event type, Events.EventArgs args) implements Event<Engine_Event> {

    }
}

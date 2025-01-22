package ggj.util;

import ggj.event.model.api.Event;
import ggj.event.model.api.EventType;

public class Format {
    public static String event(Event<?> event) {
        return format("", event.type().toString(), event.args());
    }

    private static String format(String base, Object... args) {
        //format args pretty? recurse if type is recognized?
        return base.formatted(args);
    }
}

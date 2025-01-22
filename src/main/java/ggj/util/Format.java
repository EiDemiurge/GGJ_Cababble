package ggj.util;

import ggj.event.model.api.Event;
import ggj.util.datastruct.StringMap;

import java.util.Map;

public class Format {
    public static String event(Event<?> event) {

        return format("%s: [%s]", event.type().toString(), event.args());
    }

    private static String format(String base, Object... args) {
        //format args pretty? recurse if type is recognized?
        return base.formatted(args);
    }

    public static String map(Map<?, ?> map) {
        StringBuilder body = new StringBuilder();
        for (Object o : map.keySet()) {
            body.append(o).append("=").append(map.get(o)).append(",");
        }
        return "{%s}".formatted(body);
    }

    public static String array(Object[] array) {
        StringBuilder body = new StringBuilder();
        for (Object o : array) {
            body.append(o).append(",");
        }
        return "[%s]".formatted(body);
    }
}

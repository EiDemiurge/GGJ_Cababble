package ggj.event.build;

import ggj.event.model.api.Event;
import ggj.event.model.api.EventType;

import java.util.function.BiFunction;

public class EventBuilder<T extends EventType> {

    private T type;
    private BiFunction<T, Events.EventArgs, Event<T>> creator;
    private String[] keys;
    private Object[] values;
    private Object value;
    private String key;
    Events.EventArgs args;

    public EventBuilder<T> creator(BiFunction<T, Events.EventArgs, Event<T>> creator) {
        this.creator = creator;
        return this;
    }

    // public EventBuilder<T> value(String key, Object value) {
    //     return this;
    // }

    public EventBuilder<T> arg(Object value) {
        if (args != null) {
            throw new RuntimeException("Double init of event args with " + value);
        }
        this.args = new Events.EventArgs(value);
        return this;
    }

    // public EventBuilder<T> keys(String... keys) {
    //     this.keys = keys;
    //     return this;
    // }
    //
    // public EventBuilder<T> values(Object... values) {
    //     this.values = values;
    //     return this;
    // }


    public void fire() {
        if (args == null){
            args = new Events.EmptyEventArgs();
        }
        Events.fire(creator.apply(type, args));
    }

    public EventBuilder(T type) {
        this.type = type;
    }
}

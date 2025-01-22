package ggj.event.build;

import ggj.event.model.Engine_Event;
import ggj.event.model.Engine_Event.EngineEvent;

import ggj.event.model.Game_Event;
import ggj.event.model.Game_Event.GameEvent;

import ggj.event.model.User_Event;
import ggj.event.model.User_Event.UserEvent;

import ggj.event.model.Gui_Event;
import ggj.event.model.Gui_Event.GuiEvent;
import ggj.event.model.api.Event;
import ggj.event.model.api.EventType;
import ggj.event.process.EventQueue;
import ggj.util.Log;
import ggj.util.datastruct.StringMap;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

// @Getter for static fields?
@SuppressWarnings({"rawtypes", "unchecked"})
public class Events {

    private static final Map<Class, EventQueue> queueMap = new HashMap<>();


    //add block() to wait until handled?

    public static <T extends EventType> void fire(Event<T> event) {
        try {
            queueMap.get(event.getClass()).put(event);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Log.info("Event added to queue: " + ggj.util.Format.event(event));
    }

    public static <E extends Event<?>> EventQueue<E> newQueue(Class<E> clazz) {
        EventQueue<E> queue = new EventQueue<>();
        queueMap.put(clazz, queue);
        return queue;
    }

    public static EventBuilder<Engine_Event> engine(Engine_Event type) {
        return builder(type, EngineEvent::new);
    }

    public static EventBuilder<User_Event> user(User_Event type) {
        return builder(type, UserEvent::new);
    }

    public static EventBuilder<Game_Event> game(Game_Event type) {
        return builder(type, GameEvent::new);
    }

    public static EventBuilder<Gui_Event> gui(Gui_Event type) {
        return builder(type, GuiEvent::new);
    }

    private static <E extends EventType> EventBuilder<E> builder(E type, BiFunction<E, EventArgs, Event<E>> creator) {
        return new EventBuilder<>(type).creator(creator);
    }


    public static class EventArgs {
        public final StringMap<?> kwargs;
        public final Object[] args;

        public EventArgs(Object... args) {
            this(null, args);
        }

        public EventArgs(StringMap<?> kwargs) {
            this(kwargs, null);
        }

        public EventArgs(StringMap<?> kwargs, Object... args) {
            this.kwargs = kwargs;
            this.args = args;
        }

        public String value(){
            return args[0].toString();
        }
        public String string(String key){
            return kwargs.get(key).toString();
        }

        //should go into StringMapGeneric?
        public Integer num(String key){
            // optional?
            return Integer.valueOf(kwargs.get(key).toString());
        }
    }

    public static class EmptyEventArgs extends EventArgs {
        public EmptyEventArgs() {
            super(new StringMap<>());
        }
    }
}

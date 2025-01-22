package ggj.engine.logic.entity.action;

import ggj.event.build.Events;
import ggj.event.model.Game_Event;

public class Actions {

    public static ActionBuilder action(ActionType type){
        return new ActionBuilder(type);

    }

    public static void handle(Action action) {
        Events.game(action.eventType()).with(action.keys()).fire();
    }

    public static final record Action(Game_Event eventType, String[] keys, Object... values){

    }
}

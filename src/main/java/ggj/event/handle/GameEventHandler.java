package ggj.event.handle;

import ggj.event.build.Events;
import ggj.event.model.Game_Event;
import ggj.event.model.Gui_Event;
import ggj.event.process.handle.EventHandler;

public class GameEventHandler implements EventHandler<Game_Event.GameEvent> {

    @Override
    public void accept(Game_Event.GameEvent gameEvent) {
        switch (gameEvent.type()) {
            case MSG_SENT_NPC -> {
                gameEvent.args().string("name");
                //update some RPG state - how does this message impact others?
                //keyword may have been added

                // Events.engine(); //from there we actually might do some deltas?
                Events.gui(Gui_Event.CHAT_MSG_APPEND).keys().values().fire();
            }
        }
    }
}

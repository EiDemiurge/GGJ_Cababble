package ggj.event.process.handle;

import ggj.event.build.Events;
import ggj.event.model.Game_Event;
import ggj.event.model.Gui_Event;

public class GameEventHandler implements EventHandler<Game_Event.GameEvent> {

    @Override
    public void accept(Game_Event.GameEvent gameEvent) {
        switch (gameEvent.type()) {
            case UPVOTE -> {
                int msgId = gameEvent.args().num("msgId");
                int sourceId = gameEvent.args().num("sourceId");
                ggj.engine.rules.Rules.upvote(msgId, sourceId);
                //just update ui?
                Events.gui(Gui_Event.CHAT_MSG_UPVOTED).args(gameEvent.args()).fire();
            }
            case MSG_SENT_NPC -> {

                gameEvent.args().num("userId");
                // Rules.processMsgImpact();
                //How to ensure that I don't get fucked by invisible args?


                // String username = gameEvent.args().string("username");
                //update some RPG state - how does this message impact others?
                //keyword may have been added

                // Events.engine(); //from there we actually might do some deltas?
                Events.gui(Gui_Event.CHAT_MSG_APPEND).args(gameEvent.args()).fire();
            }
        }
    }
}

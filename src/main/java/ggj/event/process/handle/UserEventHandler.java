package ggj.event.process.handle;

import ggj.engine.logic.model.ModelChat;
import ggj.event.build.Events;
import ggj.event.model.Gui_Event;
import ggj.event.model.User_Event;

import java.util.function.Supplier;

public class UserEventHandler implements EventHandler<User_Event.UserEvent> {

    private final Supplier<ModelChat.ChatUser> playerUser;
    private final Supplier<Integer> playerUserId;

    public UserEventHandler(Supplier<ModelChat.ChatUser> playerUser, Supplier<Integer> playerUserId) {
        this.playerUser = playerUser;
        this.playerUserId = playerUserId;
    }

    @Override
    public void accept(User_Event.UserEvent userEvent) {

        switch (userEvent.type()) {
            case MSG_SENT -> {
                playerMessageSent(userEvent.args());
            }
            case RE_ROLL -> {
            }
            case ROOM_SWITCH -> {
            }
        }
    }

    private void playerMessageSent(Events.EventArgs args) {
        args.put("userId", playerUserId.get());
        Events.gui(Gui_Event.CHAT_MSG_APPEND).args(args).fire();
        // Events.gui(Gui_Event.CHAT_MSG_APPEND).keys("username","message").values(name, args).fire();
    }
}

package ggj.event.process.handle;

import ggj.engine.logic.model.ModelChat;

import java.util.function.Function;

import static ggj.event.model.Gui_Event.*;

public class MockGuiEventHandler implements EventHandler<GuiEvent> {

    private final Function<Integer, ModelChat.ChatUser> userDataProvider;

    public MockGuiEventHandler(Function<Integer, ModelChat.ChatUser> userDataProvider) {
        this.userDataProvider = userDataProvider;
    }

    @Override
    public void accept(GuiEvent event) {
        switch (event.type()) {
            case CHAT_MSG_APPEND -> {

                Integer userId = event.args().num("userId");
                ModelChat.ChatUser data = userDataProvider.apply(userId);

                System.out.println(data.name()+ " writes: \n" + event.args().string("message"));
            }
        }
    }
}

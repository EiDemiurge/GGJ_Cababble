package ggj.engine.logic.entity;

import static ggj.engine.logic.model.ModelChat.*;

public class Message extends ChatEntity<ChatUserMessage> {
    public Message(ChatUserMessage model) {
        super(model);
    }

    @Override
    public EntityType getType() {
        return EntityType.Message;
    }
}

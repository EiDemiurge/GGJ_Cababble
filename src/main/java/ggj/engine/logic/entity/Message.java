package ggj.engine.logic.entity;

import ggj.engine.logic.entity.stat.Parameter;
import ggj.engine.logic.entity.stat.Property;
import ggj.engine.logic.entity.stat.param.MsgParam;
import ggj.engine.logic.entity.stat.prop.MsgProp;
import ggj.engine.logic.model.ModelChat;

import static ggj.engine.logic.model.ModelChat.*;

public class Message extends ChatEntity<ChatUserMessage> {

    public static final Property<ModelChat.ChatUserMessage>[] props = MsgProp.values();
    public static final Parameter<ModelChat.ChatUserMessage>[] params = MsgParam.values();

    private static int MSG_ID=0;

    public Message(ChatUserMessage model) {
        super(model);
    }

    @Override
    protected int newId() {
        return MSG_ID++;
    }

    @Override
    protected Property<ChatUserMessage>[] getPropConstants() {
        return props;
    }

    @Override
    protected Parameter<ChatUserMessage>[] getParamConstants() {
        return params;
    }

    @Override
    public EntityType getType() {
        return EntityType.Message;
    }
}

package ggj.engine.logic.entity;

import ggj.engine.logic.entity.stat.Parameter;
import ggj.engine.logic.entity.stat.Property;
import ggj.engine.logic.entity.stat.param.RoomParam;
import ggj.engine.logic.entity.stat.prop.RoomProp;

import static ggj.engine.logic.model.ModelChat.*;

public class Room extends ChatEntity<ChatRoom> {

    public static final Property<ChatRoom>[] props = RoomProp.values();
    public static final Parameter<ChatRoom>[] params = RoomParam.values();

    public Room(ChatRoom model) {
        super(model);
    }

    @Override
    protected Property<ChatRoom>[] getPropConstants() {
        return props;
    }

    @Override
    protected Parameter<ChatRoom>[] getParamConstants() {
        return params;
    }

    @Override
    public EntityType getType() {
        return EntityType.Room;
    }
}

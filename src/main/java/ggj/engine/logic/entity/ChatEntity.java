package ggj.engine.logic.entity;

import ggj.engine.util.stat.ParamMap;
import ggj.engine.util.stat.PropMap;

import static ggj.engine.logic.model.ModelChat.*;

public abstract class ChatEntity<M extends EntityModel> {
    public static int ID = 0;
    protected int id;
    protected ParamMap base;
    protected ParamMap current;
    protected PropMap props;

    public ChatEntity(M model) {
        id = ID++;

    }

    public enum EntityType {
        User,
        Message,
        Room,
        Game,
    }

    public abstract EntityType getType();

    public TargetRef getRef() {
        return new TargetRef(id);
    }

    public record TargetRef(int id) {
    }
}

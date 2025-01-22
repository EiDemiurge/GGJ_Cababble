package ggj.engine.logic.entity;

import ggj.engine.logic.entity.stat.Parameter;
import ggj.engine.logic.entity.stat.Property;
import ggj.engine.logic.entity.stat.param.UserParam;
import ggj.engine.logic.entity.stat.prop.UserProp;
import ggj.engine.logic.model.ModelChat;
import ggj.engine.rpg.model.ModelRpg;

/*
created from a template, but they DO have their associated state!
 */
public class User extends ChatEntity<ModelChat.ChatUser> {

    // Npc npc;
    public User(ModelChat.ChatUser model) {
        super(model);
    }

    @Override
    protected Property<ModelChat.ChatUser>[] getPropConstants() {
        return UserProp.values();
    }

    @Override
    protected Parameter<ModelChat.ChatUser>[] getParamConstants() {
        return UserParam.values();
    }


    @Override
    public EntityType getType() {
        return EntityType.User;
    }
}

package ggj.engine.logic.entity;

import ggj.engine.logic.entity.stat.Parameter;
import ggj.engine.logic.entity.stat.Property;
import ggj.engine.logic.entity.stat.param.UserParam;
import ggj.engine.logic.entity.stat.prop.UserProp;
import ggj.engine.logic.model.ModelChat;

/*
created from a template, but they DO have their associated state!
 */
public class User extends ChatEntity<ModelChat.ChatUser> {

    // Npc npc; only when we actually impl some LOGIC
    private static int USER_ID = 0;

    public User(ModelChat.ChatUser model) {
        super(model);
    }

    @Override
    protected int newId() {
        return USER_ID++;
    }

    @Override
    public ModelChat.ChatUser createModel() {
        //TODO
        return new ModelChat.ChatUser(props.get(UserProp.NAME), null, null, 0, 0);
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

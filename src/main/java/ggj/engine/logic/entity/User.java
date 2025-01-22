package ggj.engine.logic.entity;

import ggj.engine.logic.model.ModelChat;
import ggj.engine.rpg.model.ModelRpg;

/*
created from a template, but they DO have their associated state!
 */
public class User extends ChatEntity {

    ModelRpg.RpgUser rpg;
    ModelChat.ChatUser chat;

    public User(ModelChat.EntityModel model) {
        super(model);
    }


    @Override
    public EntityType getType() {
        return EntityType.User;
    }
}

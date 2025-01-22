package ggj.engine.logic.entity;

import ggj.engine.logic.model.ModelChat;

public class Game extends ChatEntity<ModelChat.ChatGame> {

    public Game(ModelChat.ChatGame model) {
        super(model);
    }

    @Override
    public EntityType getType() {
        return EntityType.Game;
    }
}

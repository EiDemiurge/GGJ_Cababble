package ggj.engine.logic.model;

public class ModelChat {

    public interface EntityModel {
    }

    public record ChatGame() implements EntityModel {

    }
    public record ChatUser() implements EntityModel {

    }

    public record ChatUserMessage() implements EntityModel {

    }

    public record ChatSystemMessage() implements EntityModel {

    }

    public record ChatRoom() implements EntityModel {

    }

    //also entity?
    public record ChatKeyword() {

    }
}

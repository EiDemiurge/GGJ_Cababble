package ggj.engine.logic.model;

public class ModelChat {

    public interface EntityModel {
    }

    public record ChatGame(int agency, String base) implements EntityModel {

    }
    public record ChatUser(String name, String role, String avatar, int upvotes, int downvotes) implements EntityModel {

    }

    public record ChatUserMessage(int userId, String message) implements EntityModel {

    }
    //maybe not? Can it be just a string without anything else?
    public record ChatSystemMessage() implements EntityModel {

    }

    public record ChatRoom() implements EntityModel {

    }

    //also entity?
    public record ChatKeyword() {

    }
}

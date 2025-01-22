package ggj.engine.logic.state;

import ggj.engine.logic.entity.Game;
import ggj.engine.logic.entity.Message;
import ggj.engine.logic.entity.Room;
import ggj.engine.logic.entity.User;
import ggj.engine.logic.entity.stat.ParamMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameState {

    static GameState state;

    public static GameState getState() {
        return state;
    }
    public static void create(Game game, List<User> users, List<Room> rooms){
        state = new GameState(game, users, rooms);
    }

    public final Game game;
    public final List<User> users;
    public final List<Room> rooms;

    //TODO how to keep these up to date?
    private final Map<Integer, List<Message>> roomIdToMsg = new HashMap<>();
    private final Map<Integer, List<User>> roomIdToUser = new HashMap<>();
    private final Map<Integer, List<Message>> userIdToMsg = new HashMap<>();

    private GameState(Game game, List<User> users, List<Room> rooms) {
        this.game = game;
        this.users = users;
        this.rooms = rooms;
    }
}

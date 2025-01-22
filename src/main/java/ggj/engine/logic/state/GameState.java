package ggj.engine.logic.state;

import ggj.engine.logic.entity.Game;
import ggj.engine.logic.entity.Room;
import ggj.engine.logic.entity.User;
import ggj.engine.logic.entity.stat.ParamMap;

import java.util.List;

public class GameState {

    static GameState state;

    public static GameState getState() {
        return state;
    }
    public static void create(){
        //TODO
        // state = new GameState(game, users, rooms);
    }

    public final Game game;
    public final List<User> users;
    public final List<Room> rooms;

    private GameState(Game game, List<User> users, List<Room> rooms) {
        this.game = game;
        this.users = users;
        this.rooms = rooms;
    }
}

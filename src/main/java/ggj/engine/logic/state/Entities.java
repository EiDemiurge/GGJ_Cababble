package ggj.engine.logic.state;

import ggj.engine.logic.entity.User;
import ggj.util.meta.Inject;

public class Entities {

    public static User PLAYER;
    private static EntityProvider<User> userProvider;

    @Inject
    public static void setup(User PLAYER, EntityProvider<User> userProvider ){
        Entities.PLAYER = PLAYER;
        Entities.userProvider = userProvider;
    }
    //findByName?

    public static User findUser(int id){
        return userProvider.find(id);
    }

    // public static Room findRoom(int id){
    //     return roomProvider.find(id);
    // }
}

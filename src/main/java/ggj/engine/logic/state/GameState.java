package ggj.engine.logic.state;

import ggj.engine.logic.entity.Room;
import ggj.engine.logic.entity.User;
import ggj.engine.util.stat.ParamMap;

import java.util.List;

public class GameState {
    List<User> users;
    List<Room> rooms;

    ParamMap params;
    ParamMap dynamicParams; //e.g. chatRoomRep
    //derived params - global rep e.g.
}

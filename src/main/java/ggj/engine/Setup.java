package ggj.engine;

import ggj.engine.logic.entity.Game;
import ggj.engine.logic.entity.Room;
import ggj.engine.logic.entity.User;
import ggj.engine.logic.entity.action.impl.ScriptActionProvider;
import ggj.engine.logic.generator.UserActGen;
import ggj.engine.logic.generator.UserActProcessor;
import ggj.engine.logic.state.Entities;
import ggj.engine.logic.state.EntityProvider;
import ggj.engine.logic.state.GameState;
import ggj.event.ProcessorLauncher;
import ggj.event.process.QueueProcessor;
import ggj.event.process.handle.EngineEventHandler;
import ggj.event.process.handle.GameEventHandler;
import ggj.event.process.handle.MockGuiEventHandler;
import ggj.event.process.handle.UserEventHandler;

import java.util.ArrayList;
import java.util.List;

import static ggj.demo.Demo.StdUsers.*;
import static ggj.engine.logic.model.ModelChat.*;
import static ggj.event.build.Events.*;
import static ggj.event.model.Engine_Event.*;
import static ggj.event.model.Game_Event.*;
import static ggj.event.model.User_Event.*;
import static ggj.event.model.Gui_Event.*;

public class Setup {

    /**
     * All in one place at least
     */
    public static void run() {

        var engineProcessor = new QueueProcessor<>(newQueue(EngineEvent.class), new EngineEventHandler());
        var userProcessor = new QueueProcessor<>(newQueue(UserEvent.class), new UserEventHandler(
                () -> Entities.PLAYER.createModel(),
                () -> Entities.PLAYER.getUuid()));
        var guiProcessor = new QueueProcessor<>(newQueue(GuiEvent.class), new MockGuiEventHandler(id -> Entities.findUser(id).createModel()));
        var gameProcessor = new QueueProcessor<>(newQueue(GameEvent.class), new GameEventHandler());

        ProcessorLauncher.setup(engineProcessor, userProcessor, guiProcessor, gameProcessor);

        ////---------------------------------------------------------------------------\\\\
        User player = new User(new ChatUser("The Hero", "Newbie", "", 0, 0));
        EntityProvider<User> userProvider = id -> GameState.getState().users.stream().filter(user -> user.getId() == id).findAny().get();
        // EntityProvider<User> roomProvider = id -> GameState.getState().rooms.stream().filter(user -> user.getId() == id).findAny().get();

        Entities.setup(player, userProvider);

        ////---------------------------------------------------------------------------\\\\

        UserActProcessor.setup(new ScriptActionProvider());

        ////---------------------------------------------------------------------------\\\\
        //on game start?
        List<User> users = new ArrayList<>();
        users.add(Entities.PLAYER);
        users.add(new User(Bob.get()));
        users.add(new User(Bob.get()));
        users.add(new User(Admin.get()));
        // ggj.demo.Demo.ADMIN_ID = ChatEntity.ID;
        users.add(Entities.PLAYER);

        List<Room> rooms = new ArrayList<>();
        //take from DEMO?
        rooms.add(new Room(new ChatRoom("Talkinists", "")));
        GameState.create(new Game(new ChatGame(50, "You bastards!")),
                users, rooms);

        ////---------------------------------------------------------------------------\\\\
        List<UserActGen> gens = new ArrayList<>();
        gens.add(new UserActGen());
        // for (int i = 1; i < users.size(); i++) {
            // int finalI = i;
            // gens.add(new UserActGen(()-> users.get(finalI).createModel()));
        // }
        UserActProcessor.gameStarted(gens);
    }

}

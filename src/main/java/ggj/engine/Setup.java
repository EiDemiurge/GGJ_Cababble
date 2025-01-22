package ggj.engine;

import ggj.event.ProcessorLauncher;
import ggj.event.process.QueueProcessor;
import ggj.event.process.handle.EngineEventHandler;
import ggj.event.process.handle.GameEventHandler;
import ggj.event.process.handle.GuiEventHandler;
import ggj.event.process.handle.UserEventHandler;

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
        var userProcessor = new QueueProcessor<>(newQueue(UserEvent.class), new UserEventHandler());
        var guiProcessor = new QueueProcessor<>(newQueue(GuiEvent.class), new GuiEventHandler());
        var gameProcessor = new QueueProcessor<>(newQueue(GameEvent.class), new GameEventHandler());

        ////---------------------------------------------------------------------------\\\\
        ProcessorLauncher.setup(engineProcessor, userProcessor, guiProcessor, gameProcessor);


    }
}

package ggj.event;

import ggj.event.process.QueueProcessor;

import static ggj.event.model.Engine_Event.*;
import static ggj.event.model.User_Event.*;
import static ggj.event.model.Gui_Event.*;
import static ggj.event.model.Game_Event.*;

public class ProcessorLauncher {

    private static QueueProcessor<EngineEvent> engineProcessor;
    private static QueueProcessor<UserEvent> userProcessor;
    private static QueueProcessor<GuiEvent> guiProcessor;
    private static QueueProcessor<GameEvent> gameProcessor;

    //@Injection
    public static void setup(QueueProcessor<EngineEvent> engineProcessor,
                             QueueProcessor<UserEvent> userProcessor,
                             QueueProcessor<GuiEvent> guiProcessor,
                             QueueProcessor<GameEvent> gameProcessor) {
        ProcessorLauncher.engineProcessor = engineProcessor;
        ProcessorLauncher.userProcessor = userProcessor;
        ProcessorLauncher.guiProcessor = guiProcessor;
        ProcessorLauncher.gameProcessor = gameProcessor;
    }

    public static void launch() {
        launch(engineProcessor, "engine");
        launch(userProcessor, "user");
        launch(guiProcessor, "gui");
        launch(gameProcessor, "game");
    }

    private static void launch(QueueProcessor<?> processor, String hint) {
        new Thread(processor, hint + " event processor").start();
    }
}

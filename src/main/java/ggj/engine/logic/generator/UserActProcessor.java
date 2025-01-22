package ggj.engine.logic.generator;

import ggj.engine.logic.entity.action.ActionProvider;
import ggj.engine.logic.entity.action.Actions;

import java.util.List;

import static ggj.engine.logic.entity.action.Actions.*;

public class UserActProcessor {

    private static List<UserActGen> userGens;
    private static ActionProvider actionsProvider;

    public static void setup(ActionProvider actionsProvider) {
        UserActProcessor.actionsProvider = actionsProvider;
    }

    public static void gameStarted(List<UserActGen> userGens) {
        UserActProcessor.userGens = userGens;
    }

    public void start() {
        //TODO does it ever pause? it should be able to exit for main menu e.g.
        while (true) {
            updateGenerators();
            process();
        }
    }

    private void updateGenerators() {
        userGens.removeIf(gen -> !gen.update());
    }

    public void process() {
        for (UserActGen userGen : userGens) {
            Action action = actionsProvider.getNextAction(
                    userGen.getPreviousAction(), userGen.getData());
            handle(action);
        }
    }
}

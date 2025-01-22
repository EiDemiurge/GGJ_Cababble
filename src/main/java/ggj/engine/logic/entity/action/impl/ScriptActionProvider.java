package ggj.engine.logic.entity.action.impl;

import ggj.engine.logic.entity.action.ActionProvider;
import ggj.engine.logic.entity.action.ActionType;
import ggj.engine.logic.entity.action.Actions;
import ggj.engine.rpg.model.ModelRpg;

import static ggj.engine.logic.entity.action.Actions.action;

public class ScriptActionProvider implements ActionProvider {
    int step = 0;
    Actions.Action[] scriptedAction = {

            action(ActionType.MESSAGE).keys("name;room;source").values("Dobby;WizzyWaz;Admin").build(),
            //how to deal with TIME?!

    };

    @Override
    public Actions.Action getNextAction(Actions.Action previous, ModelRpg.RpgUser data) {
        if (step >= scriptedAction.length) {
            throw new RuntimeException("No more actions in the script!");
        }
        return scriptedAction[step++];
    }
}

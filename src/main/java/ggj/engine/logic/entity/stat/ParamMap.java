package ggj.engine.logic.entity.stat;

import ggj.engine.logic.entity.stat.generic.IntParam;
import ggj.engine.logic.model.ModelChat;

import java.util.Map;

public class ParamMap<E extends ModelChat.EntityModel> {
    Map<Parameter<E>, IntParam> map;

    public void put(Parameter<E> param, int value){

    }
}

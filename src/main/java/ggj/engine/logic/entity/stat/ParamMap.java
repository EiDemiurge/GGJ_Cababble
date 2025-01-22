package ggj.engine.logic.entity.stat;

import ggj.engine.logic.model.ModelChat;

import java.util.HashMap;
import java.util.Map;

public class ParamMap<E extends ModelChat.EntityModel> {
    Map<Parameter<E>, Integer> map = new HashMap<>();;

    public Integer put(Parameter<E> key, Integer value) {
        return map.put(key, value);
    }
    public Integer get(Object key) {
        return map.get(key);
    }
}

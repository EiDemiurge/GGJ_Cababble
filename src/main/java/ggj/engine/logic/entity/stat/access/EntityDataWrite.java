package ggj.engine.logic.entity.stat.access;

import ggj.engine.logic.entity.stat.Parameter;
import ggj.engine.logic.entity.stat.Property;

import java.util.function.BiConsumer;

import static ggj.engine.logic.model.ModelChat.*;
import static ggj.engine.logic.entity.stat.access.EntityDataWriteProvider.*;

public class EntityDataWrite<E extends EntityModel> implements ParamSetter<E>, PropSetter<E> {

    private final BiConsumer<Parameter<E>, Integer> paramFunc;
    private final BiConsumer<Property<E>, String> propFunc;

    protected EntityDataWrite(BiConsumer<Parameter<E>, Integer> paramFunc, BiConsumer<Property<E>, String> propFunc) {
        this.paramFunc = paramFunc;
        this.propFunc = propFunc;
    }

    public void set(Parameter<E> parameter, int value) {
        paramFunc.accept(parameter, value);
    }

    public void set(Property<E> prop, String value) {
        propFunc.accept(prop, value);
    }
}

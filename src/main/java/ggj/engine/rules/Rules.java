package ggj.engine.rules;

import ggj.engine.logic.entity.Message;
import ggj.engine.logic.entity.User;
import ggj.engine.logic.entity.stat.param.MsgParam;

import java.util.function.Function;

public class Rules {

    static Function<Integer, Message> messageProvider;
    static Function<Integer, User> userProvider;

    public static void upvote(int msgId, int sourceId) {
        //increment msgId
        //add to the list of upvoters

        messageProvider.apply(msgId).write().increment(MsgParam.UPVOTES);

    }

    public void processMsgImpact(){
/*
At this point we just want to test.

A message must be in response to something? Tied to a keyword?

=> EngineEvents? Is it something that we reflect, or request?
 */

    }
}

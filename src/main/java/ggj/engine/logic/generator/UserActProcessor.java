package ggj.engine.logic.generator;

import java.util.List;

public class UserActProcessor {

    //synchronized?
    List<UserActGen> userGens;

    // MessageGenerationBackend backend; scripted, gpt, ...

    public void start(){
        //TODO does it ever pause? it should be able to exit for main menu e.g.
    }

    public void process(){
        for (UserActGen userGen : userGens) {
            /*
            accrue some params that lead to action with those params
            actions:
            upvote
            downvote
            message
            ban (admin)
            DM (super-admin)

             */
        }
    }
}

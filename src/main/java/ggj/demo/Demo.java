package ggj.demo;

import ggj.engine.logic.model.ModelChat;

public class Demo {
    public enum StdUsers {
        Bob(new ModelChat.ChatUser("Dobby","","",0,0)),
        Admin(new ModelChat.ChatUser("Adamin","","",0,0)),
        ;
        final ModelChat.ChatUser user;

        StdUsers(ModelChat.ChatUser user) {
            this.user = user;
        }

        public ModelChat.ChatUser get(){
                return user;
            }
    }
}

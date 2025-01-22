package ggj.engine;

import ggj.event.ProcessorLauncher;
import ggj.util.Log;

public class EngineLauncher {
    public static void main(String[] args) {
        launch();
    }

    public static void launch() {
        Log.info("Engine starting...");
        Setup.run();
        //check setup
        ProcessorLauncher.launch();
    }
}

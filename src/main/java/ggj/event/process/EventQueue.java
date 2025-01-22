package ggj.event.process;

import ggj.event.model.api.Event;

import java.util.concurrent.PriorityBlockingQueue;

public class EventQueue<E extends Event> extends PriorityBlockingQueue<E> {

    @Override
    public E take() throws InterruptedException {
        return super.take();
    }
}

package com.jeet.controller.factory;

import java.util.concurrent.ThreadFactory;

/**
 * Created by Aroras on 7/16/2016.
 */
public class TaskThreadFactory implements ThreadFactory {
    private ThreadGroup tg = new ThreadGroup("Task Group");
    public Thread newThread(Runnable r) {
        return new Thread(tg, r);
    }
}

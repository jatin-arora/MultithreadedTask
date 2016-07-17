package com.jeet.api;

/**
 * Created by Aroras on 6/26/2016.
 */
public interface ITask<T> extends Runnable {

    public boolean begin();
    public boolean stop();
    public boolean submit(ISubTask subTask);
}

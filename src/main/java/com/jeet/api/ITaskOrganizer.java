package com.jeet.api;


import java.util.List;

/**
 * Created by Aroras on 7/6/2016.
 */
public interface ITaskOrganizer extends Interruptable {

    public boolean organize(List<Thread> threads, TaskOrganizerListener organizerListener);

}

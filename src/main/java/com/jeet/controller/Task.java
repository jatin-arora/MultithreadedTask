package com.jeet.controller;

import com.jeet.api.*;
import com.jeet.config.Config;
import com.jeet.config.Parser;
import com.jeet.controller.factory.TaskThreadFactory;
import com.jeet.controller.organizers.OrganizerFactory;
import com.jeet.controller.organizers.SerialTaskOrganizer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadFactory;

/**
 * Created by Aroras on 7/6/2016.
 */
public final class Task implements ITask {
    private final List<ISubTask> subTasks;
    private final ThreadFactory tf;
    private TaskState state;
    private Thread taskThread;
    private final Config config;
    private ITaskOrganizer taskOrganizer;

    public Task(){
        this( new ArrayList<ISubTask>());
    }

    public Task(List<ISubTask> subTasks){
        this.tf = new TaskThreadFactory();
        this.subTasks = subTasks;
        state = TaskState.CREATED;
        config = new Parser().parse("config.xml").getConfig();
    }

    public boolean begin() {
        boolean begin= false;
        if( taskThread == null) {
            taskThread = tf.newThread(this);
            taskThread.start();
            begin = true;
            state = TaskState.BEGIN;
        }
        return begin;
    }

    public boolean stop() {
        taskOrganizer.interrupt();
        state = TaskState.STOPPED;
        taskThread.interrupt();
        return true;
    }

    public void run() {
        state = TaskState.RUNNING;
        List<Thread> subTaskThreads = new ArrayList<Thread>();
        for( ISubTask subTask : subTasks){
            Thread subTaskThread = tf.newThread(subTask);
            subTaskThreads.add(subTaskThread);
        }
        taskOrganizer = OrganizerFactory.createOrganizer(config.getExecutionPolicy());
        taskOrganizer.organize(subTaskThreads, new TaskOrganizerListenerImpl());
    }

    class TaskOrganizerListenerImpl implements TaskOrganizerListener{
        public void notifyCompleted() {
            System.out.println("TASK -------------------->>  COMPLETED");
        }

        public void notifyStopped() {
            System.out.println(" TASK  ------------------ >> STOPPED");
        }

    }

    public boolean submit(ISubTask subTask){
        if( state == TaskState.CREATED){
            subTasks.add(subTask);
            return true;
        }
        return false;
    }
}
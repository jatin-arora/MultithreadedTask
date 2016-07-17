package com.jeet.controller.organizers;

import com.jeet.api.ITaskOrganizer;
import com.jeet.api.TaskOrganizerListener;

import java.util.List;

/**
 * Created by Aroras on 7/16/2016.
 */
public class ParallelTaskOrganizer implements ITaskOrganizer {
    private List<Thread> threads;
    private TaskOrganizerListener organizerListener;
    private volatile boolean interrupted;
    public boolean organize(List<Thread> threads, TaskOrganizerListener organizerListener) {
        this.threads = threads;
        this.organizerListener = organizerListener;
        for(Thread th : threads){
            th.start();
        }
        return true;
    }

    public void interrupt() {
        this.interrupted = true;
        for(Thread th : threads){
            th.interrupt();
        }
        organizerListener.notifyStopped();
    }

    class MonitorParallelThreads extends Thread{

        public void run(){
            while( threads.size() > 0 && !interrupted){
                for( Thread th : threads){
                    if( !th.isAlive()){
                        threads.remove(th);
                        continue;
                    }
                }
            }
            if( interrupted){
                organizerListener.notifyStopped();
            }else{
                organizerListener.notifyCompleted();
            }
        }
    }
}

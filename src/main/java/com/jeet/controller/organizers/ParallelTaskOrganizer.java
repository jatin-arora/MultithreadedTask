package com.jeet.controller.organizers;

import com.jeet.api.ITaskOrganizer;
import com.jeet.api.TaskOrganizerListener;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

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
        new MonitorParallelThreads().start();
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
            System.out.println("-------------------------------");
            while( threads.size() > 0 && !interrupted){
                System.out.println("RUNNING");
                for( Thread th : threads){
                    if( !th.isAlive()){
                        threads.remove(th);
                        continue;
                    }else{
                        try {
                            Thread.currentThread().sleep(10, 10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
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

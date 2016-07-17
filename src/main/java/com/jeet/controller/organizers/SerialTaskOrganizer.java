package com.jeet.controller.organizers;

import com.jeet.api.ITaskOrganizer;
import com.jeet.api.TaskOrganizerListener;

import java.util.List;

/**
 * Created by Aroras on 7/16/2016.
 */
public class SerialTaskOrganizer implements ITaskOrganizer{
    private List<Thread> threads;
    private TaskOrganizerListener organizerListener;
    private volatile boolean interrupted;
    public boolean organize(List<Thread> threads, TaskOrganizerListener organizerListener){
        this.threads = threads;
        this.organizerListener = organizerListener;
        new SerialThread().start();
        return true;
    }

    public void interrupt() {
        interrupted = true;
        for( Thread subTaskThread :threads){
            subTaskThread.interrupt();
        }
    }

    class SerialThread extends Thread{
        public void run(){
            int i = 0;
            int size = threads.size();
            System.out.println("SIZE :: "+size);
            while( i < size && !interrupted){
                Thread th = threads.get(i);
                th.start();
                while( th.isAlive() ){
                    System.out.println("222222222");
                    try {
                        Thread.sleep(10, 10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
                i++;
            }
            if( interrupted){
                organizerListener.notifyStopped();
            }else {
                organizerListener.notifyCompleted();
            }
        }
    }
}

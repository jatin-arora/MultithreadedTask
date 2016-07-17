package client;

import com.jeet.api.ISubTask;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Aroras on 7/16/2016.
 */
public class SampleThread1 implements ISubTask {
    private AtomicInteger i = new AtomicInteger(0);
    public void run() {
        while(!Thread.currentThread().isInterrupted() && i.get() < 10){
            System.out.println(" counter for thread "+Thread.currentThread().getName()+" is "+i.getAndIncrement());
            System.out.println(Thread.currentThread().getName()+" Thread.currentThread().isInterrupted(): "+Thread.currentThread().isInterrupted());
            try {
                Thread.currentThread().sleep(82);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().getName()+" EXP Thread.currentThread().isInterrupted(): "+Thread.currentThread().isInterrupted());
            }
        }
    }

    }

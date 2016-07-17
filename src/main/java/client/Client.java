package client;

import com.jeet.api.ISubTask;
import com.jeet.api.ITask;
import com.jeet.config.Parser;
import com.jeet.controller.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aroras on 7/6/2016.
 */
public class Client {
    public static void main(String[] args) {
        ITask task = init();
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       task.stop();
    }

    private static ITask init(){
        SampleThread1 t1 = new SampleThread1();
        SampleThread1 t2 = new SampleThread1();
        SampleThread1 t3 = new SampleThread1();
        ITask task = new Task();
        task.submit(t1);
        task.submit(t2);
        task.submit(t2);
        task.submit(t3);
        /*task.submit(t1);
        task.submit(t1);
        task.submit(t1);*/
        task.begin();
        return task;
    }
}

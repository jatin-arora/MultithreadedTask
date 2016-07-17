package com.jeet.controller.organizers;

import com.jeet.api.ExecutionPolicy;
import com.jeet.api.ITaskOrganizer;

/**
 * Created by Aroras on 7/16/2016.
 */
public class OrganizerFactory {

    public static ITaskOrganizer createOrganizer(ExecutionPolicy executionPolicy){
        ITaskOrganizer organizer = null;
        switch (executionPolicy){
            case SERIAL:
                organizer = new SerialTaskOrganizer();
                 break;
            case PARALLEL:
                organizer = new ParallelTaskOrganizer();
                break;
        }
        return organizer;
    }
}

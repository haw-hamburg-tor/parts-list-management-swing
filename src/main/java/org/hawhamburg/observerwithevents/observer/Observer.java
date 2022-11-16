package org.hawhamburg.observerwithevents.observer;

import org.hawhamburg.observerwithevents.event.Event;

public interface Observer {

    /**
     * Operation that is called by an Observee in order to
     * notify an Observer about an Event.
     */
    void update(Event event);
}

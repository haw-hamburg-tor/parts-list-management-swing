package org.hawhamburg.observer;


public interface Observer {

    /**
     * Operation that is called by an Observee in order to
     * notify an Observer about an Event.
     */
    void update();
}

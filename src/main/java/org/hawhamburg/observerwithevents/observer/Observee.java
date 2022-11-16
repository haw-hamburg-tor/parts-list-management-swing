package org.hawhamburg.observerwithevents.observer;

import org.hawhamburg.observerwithevents.event.Event;

import java.util.HashSet;
import java.util.Set;

public abstract class Observee {

    private final transient Set<Observer> observers;

    protected Observee() {
        this.observers = new HashSet<>();
    }

    /**
     * Attaches an Observer to this Observee.
     *
     * @param observer receives update notifications
     *                 until deregister is called for this observer.
     */
    public void register(final Observer observer) {
        this.observers.add(observer);
    }

    /**
     * Detaches an Observer from this Observee.
     *
     * @param observer does no longer receive update notifications
     *                 until register is called for this observer.
     */
    public void deregister(Observer observer) {
        this.observers.remove(observer);
    }

    /**
     * Sends update notifications to all currently registered Observers.
     */
    protected void notifyObservers(Event event) {
        this.observers.forEach(o -> o.update(event));
    }
}
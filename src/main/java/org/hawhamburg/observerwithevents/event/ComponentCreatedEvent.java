package org.hawhamburg.observerwithevents.event;

import org.hawhamburg.model.composite.Component;

public abstract class ComponentCreatedEvent implements Event {

    public abstract Component getComponent();
}

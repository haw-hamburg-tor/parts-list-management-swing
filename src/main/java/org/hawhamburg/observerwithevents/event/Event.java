package org.hawhamburg.observerwithevents.event;

import org.hawhamburg.observerwithevents.visitor.EventVisitor;

public interface Event {

    void accept(EventVisitor eventVisitor);
}

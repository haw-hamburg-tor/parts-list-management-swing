package org.hawhamburg.observerwithevents.visitor;

import org.hawhamburg.observerwithevents.event.MaterialCreatedEvent;
import org.hawhamburg.observerwithevents.event.ProductCreatedEvent;

public interface EventVisitor {

    void visit(ProductCreatedEvent productCreatedEvent);
    void visit(MaterialCreatedEvent materialCreatedEvent);
}

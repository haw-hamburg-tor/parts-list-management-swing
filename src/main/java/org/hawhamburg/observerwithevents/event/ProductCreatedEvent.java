package org.hawhamburg.observerwithevents.event;

import org.hawhamburg.model.composite.Product;
import org.hawhamburg.observerwithevents.visitor.EventVisitor;

public class ProductCreatedEvent extends ComponentCreatedEvent {

    private final Product product;

    public ProductCreatedEvent(Product product) {
        this.product = product;
    }


    @Override
    public Product getComponent() {
        return this.product;
    }

    @Override
    public void accept(EventVisitor eventVisitor) {
        eventVisitor.visit(this);
    }
}

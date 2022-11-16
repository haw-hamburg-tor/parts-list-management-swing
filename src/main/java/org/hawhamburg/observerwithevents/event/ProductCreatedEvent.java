package org.hawhamburg.observerwithevents.event;

import org.hawhamburg.model.composite.Product;

public class ProductCreatedEvent extends ComponentCreatedEvent {

    private final Product product;

    public ProductCreatedEvent(Product product) {
        this.product = product;
    }


    @Override
    public Product getComponent() {
        return this.product;
    }

}

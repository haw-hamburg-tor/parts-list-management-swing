package org.hawhamburg.controller;

import org.hawhamburg.model.singleton.ComponentRegister;
import org.hawhamburg.observerwithevents.event.Event;
import org.hawhamburg.observerwithevents.event.MaterialCreatedEvent;
import org.hawhamburg.observerwithevents.event.ProductCreatedEvent;
import org.hawhamburg.observerwithevents.observer.Observer;
import org.hawhamburg.observerwithevents.visitor.EventVisitor;
import org.hawhamburg.view.CreateProductView;

import java.util.List;
import java.util.Vector;

public class CreateProductController implements Observer {

    private final CreateProductView createProductView;

    public CreateProductController(CreateProductView createProductView) {
        this.createProductView = createProductView;
        ComponentRegister.getInstance().register(this);
    }

    public void addEntryToAddComponentTable(String name, Integer amount) {
        createProductView.addEntryToAddComponentTable(name, amount);
    }

    @Override
    public void update(Event event) {
        event.accept(new EventVisitor() {
            @Override
            public void visit(ProductCreatedEvent productCreatedEvent) {
                createProductView.addNameToComponentNameComboBox(productCreatedEvent.getComponent().getName());
            }
            @Override
            public void visit(MaterialCreatedEvent materialCreatedEvent) {
                createProductView.addNameToComponentNameComboBox(materialCreatedEvent.getComponent().getName());
            }
        });
    }

    public Vector<String> getComponentNames() {
        return new Vector<>(ComponentRegister.getInstance().getComponentNames());
    }

    public void createProduct(String name,
                              Integer price,
                              List<String> componentNames,
                              List<Integer> componentAmounts) {

        ComponentRegister.getInstance().createProduct(name, price, componentNames, componentAmounts);
    }

    public void resetView() {
        createProductView.reset();
    }
}

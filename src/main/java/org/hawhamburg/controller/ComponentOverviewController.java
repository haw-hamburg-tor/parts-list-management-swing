package org.hawhamburg.controller;

import org.hawhamburg.model.singleton.ComponentRegister;
import org.hawhamburg.observerwithevents.event.Event;
import org.hawhamburg.observerwithevents.event.MaterialCreatedEvent;
import org.hawhamburg.observerwithevents.event.ProductCreatedEvent;
import org.hawhamburg.observerwithevents.observer.Observer;
import org.hawhamburg.observerwithevents.visitor.EventVisitor;
import org.hawhamburg.view.ComponentOverviewView;

public class ComponentOverviewController implements Observer {

    private final ComponentOverviewView componentOverviewView;

    public ComponentOverviewController(ComponentOverviewView componentOverviewView) {
        this.componentOverviewView = componentOverviewView;
        ComponentRegister.getInstance().register(this);
    }

    @Override
    public void update(Event event) {
        event.accept(new EventVisitor() {
            @Override
            public void visit(ProductCreatedEvent productCreatedEvent) {
                componentOverviewView.addComponent(productCreatedEvent.getComponent());
            }
            @Override
            public void visit(MaterialCreatedEvent materialCreatedEvent) {
                componentOverviewView.addComponent(materialCreatedEvent.getComponent());
            }
        });
    }

    public void initializeComponentTable() {
        componentOverviewView.addComponents(ComponentRegister.getInstance().getComponents());
    }
}

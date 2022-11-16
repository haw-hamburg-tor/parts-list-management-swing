package org.hawhamburg.controller;

import org.hawhamburg.model.composite.Component;
import org.hawhamburg.model.singleton.ComponentRegister;
import org.hawhamburg.view.ComponentOverviewView;

public class ComponentOverviewController {

    private final ComponentOverviewView componentOverviewView;

    public ComponentOverviewController(ComponentOverviewView componentOverviewView) {
        this.componentOverviewView = componentOverviewView;
        ComponentRegister.getInstance().setComponentOverviewController(this);
    }

    public void addComponentToTable(Component component) {
        componentOverviewView.addComponent(component);    }

    public void initializeComponentTable() {
        componentOverviewView.addComponents(ComponentRegister.getInstance().getComponents());
    }
}

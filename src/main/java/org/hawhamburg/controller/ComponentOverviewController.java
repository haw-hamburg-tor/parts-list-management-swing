package org.hawhamburg.controller;

import org.hawhamburg.model.singleton.ComponentRegister;
import org.hawhamburg.observer.Observer;
import org.hawhamburg.view.ComponentOverviewView;

public class ComponentOverviewController implements Observer {

    private final ComponentOverviewView componentOverviewView;

    public ComponentOverviewController(ComponentOverviewView componentOverviewView) {
        this.componentOverviewView = componentOverviewView;
        ComponentRegister.getInstance().register(this);
    }

    @Override
    public void update() {
        componentOverviewView.resetTable();
        componentOverviewView.addComponents(ComponentRegister.getInstance().getComponents());    }

    public void initializeComponentTable() {
        componentOverviewView.addComponents(ComponentRegister.getInstance().getComponents());
    }
}

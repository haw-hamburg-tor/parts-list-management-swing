package org.hawhamburg.controller;

import org.hawhamburg.model.singleton.ComponentRegister;
import org.hawhamburg.observer.Observer;
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
    public void update() {
        var componentNames = new Vector<>(ComponentRegister.getInstance().getComponentNames());
        createProductView.setComponentNameComboBoxItems(componentNames);
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

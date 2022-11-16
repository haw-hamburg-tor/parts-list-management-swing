package org.hawhamburg.controller;

import org.hawhamburg.model.singleton.ComponentRegister;
import org.hawhamburg.model.composite.Material;
import org.hawhamburg.model.composite.Product;
import org.hawhamburg.observerwithevents.event.Event;
import org.hawhamburg.observerwithevents.event.MaterialCreatedEvent;
import org.hawhamburg.observerwithevents.event.ProductCreatedEvent;
import org.hawhamburg.observerwithevents.observer.Observer;
import org.hawhamburg.view.MaterialListView;

import java.util.Map;
import java.util.Vector;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaterialListController implements Observer {

    private final MaterialListView materialListView;
    public MaterialListController(MaterialListView materialListView) {
        this.materialListView = materialListView;
        ComponentRegister.getInstance().register(this);
    }

    @Override
    public void update(Event event) {
        if (event instanceof ProductCreatedEvent productCreatedEvent) {
            materialListView.addNameToNameComboBox(productCreatedEvent.getComponent().getName());
        }
        if (event instanceof MaterialCreatedEvent materialCreatedEvent) {
            //do nothing
        }
    }

    public Vector<String> getProductNames() {
        return new Vector<>(ComponentRegister.getInstance().getProductNames());
    }

    public void fetchMaterialList(String productName) {
        var names = new Vector<String>();
        var amounts = new Vector<Integer>();

        Product product = ComponentRegister.getInstance().getProduct(productName);

        Map<Material, Integer> materialMap = product.fetchMaterialList().stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.reducing(0, m -> 1, Integer::sum)));

        materialMap.forEach(((material, amount) -> {
            names.add(material.getName());
            amounts.add(amount);
        }));
        materialListView.setMaterialListEntries(names, amounts);
    }
}

package org.hawhamburg.model.singleton;

import org.hawhamburg.model.composite.Component;
import org.hawhamburg.model.composite.CyclicStructureException;
import org.hawhamburg.model.composite.Material;
import org.hawhamburg.model.composite.Product;
import org.hawhamburg.observerwithevents.event.MaterialCreatedEvent;
import org.hawhamburg.observerwithevents.event.ProductCreatedEvent;
import org.hawhamburg.observerwithevents.observer.Observee;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ComponentRegister extends Observee {

    private static ComponentRegister instance = null;
    private final Map<String, Material> materials;
    private final Map<String, Product> products;

    private ComponentRegister() {
        this.products = new HashMap<>();
        this.materials = new HashMap<>();
    }

    public static ComponentRegister getInstance() {
        if (instance == null) instance = new ComponentRegister();
        return instance;
    }

    public Material createMaterial(String name, Integer price) {
        var material = new Material(name, price);
        addMaterial(material);
        notifyObservers(new MaterialCreatedEvent(material));
        return material;
    }

    public Product createProduct(String name, Integer price, List<String> componentNames, List<Integer> componentAmounts) {
        try {
            var product = new Product(name, price);
            for (int i = 0; i < componentNames.size(); i++) {
                Component component = getComponent(componentNames.get(i));
                product.addPart(component, componentAmounts.get(i));
            }
            addProduct(product);
            notifyObservers(new ProductCreatedEvent(product));
            return product;

        } catch (CyclicStructureException e) {
            return null;
        }
    }

    private void addMaterial(Material material) {
        materials.put(material.getName(), material);
    }

    private void addProduct(Product product) {
        products.put(product.getName(), product);
    }

    public Product getProduct(String name) {
        return products.get(name);
    }

    public List<String> getProductNames() {
        return products.keySet().stream().sorted().toList();
    }

    public Component getComponent(String name) {
        var product = products.get(name);
        return product != null ? product : materials.get(name);
    }

    public List<Component> getComponents() {
        return Stream.concat(materials.values().stream(), products.values().stream())
                .sorted(Comparator.comparing(Component::getName)).toList();
    }

    public List<String> getComponentNames() {
        return Stream.concat(materials.keySet().stream(), products.keySet().stream()).sorted().toList();
    }
}

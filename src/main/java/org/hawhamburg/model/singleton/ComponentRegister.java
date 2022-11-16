package org.hawhamburg.model.singleton;

import org.hawhamburg.controller.ComponentOverviewController;
import org.hawhamburg.controller.CreateProductController;
import org.hawhamburg.controller.MaterialListController;
import org.hawhamburg.model.composite.Component;
import org.hawhamburg.model.composite.CyclicStructureException;
import org.hawhamburg.model.composite.Material;
import org.hawhamburg.model.composite.Product;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ComponentRegister {

    private ComponentOverviewController componentOverviewController;
    private CreateProductController createProductController;
    private MaterialListController materialListController;

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
        componentOverviewController.addComponentToTable(material);
        createProductController.addNameToNameComboBox(name);
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
            componentOverviewController.addComponentToTable(product);
            createProductController.addNameToNameComboBox(name);
            materialListController.addNameToNameComboBox(name);
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

    public void setComponentOverviewController(ComponentOverviewController componentOverviewController) {
        this.componentOverviewController = componentOverviewController;
    }

    public void setCreateProductController(CreateProductController createProductController) {
        this.createProductController = createProductController;
    }

    public void setMaterialListController(MaterialListController materialListController) {
        this.materialListController = materialListController;
    }
}

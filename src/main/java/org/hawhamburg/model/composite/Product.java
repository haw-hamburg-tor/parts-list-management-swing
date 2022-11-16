package org.hawhamburg.model.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Product extends Component {

    private final List<Component> parts;

    public Product(String name, Integer price) {
        super(name, price);
        this.parts = new ArrayList<>();
    }

    @Override
    public boolean contains(Component component) {
        if (this.equals(component)) return true;
        return this.parts.stream().anyMatch(p -> p.contains(component));
    }

    public void addPart(Component part) throws CyclicStructureException {
        if (part.contains(this)) throw new CyclicStructureException();
        this.parts.add(part);
    }

    public void addPart(Component component, Integer amount) throws CyclicStructureException {
        for (int i = 0; i < amount; i++) {
            this.addPart(component);
        }
    }

    @Override
    public Integer fetchTotalPrice() {
        return this.price + this.parts.stream().mapToInt(Component::fetchTotalPrice).sum();
    }

    @Override
    public List<Material> fetchMaterialList() {
        return parts.stream().map(Component::fetchMaterialList).flatMap(List::stream).toList();
    }

    @Override
    public String getType() {
        return "Product";
    }
}

package org.hawhamburg.observerwithevents.event;

import org.hawhamburg.model.composite.Material;
import org.hawhamburg.observerwithevents.visitor.EventVisitor;

public class MaterialCreatedEvent extends ComponentCreatedEvent {

    private final Material material;

    public MaterialCreatedEvent(Material material) {
        this.material = material;
    }

    @Override
    public Material getComponent() {
        return material;
    }

    @Override
    public void accept(EventVisitor eventVisitor) {
        eventVisitor.visit(this);
    }
}

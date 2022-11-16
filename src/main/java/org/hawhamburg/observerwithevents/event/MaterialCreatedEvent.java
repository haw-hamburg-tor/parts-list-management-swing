package org.hawhamburg.observerwithevents.event;

import org.hawhamburg.model.composite.Material;

public class MaterialCreatedEvent extends ComponentCreatedEvent {

    private final Material material;

    public MaterialCreatedEvent(Material material) {
        this.material = material;
    }

    @Override
    public Material getComponent() {
        return material;
    }

}

package org.hawhamburg.controller;

import org.hawhamburg.model.singleton.ComponentRegister;
import org.hawhamburg.view.CreateMaterialView;

public class CreateMaterialController {

    private final CreateMaterialView createMaterialView;

    public CreateMaterialController(CreateMaterialView createMaterialView) {
        this.createMaterialView = createMaterialView;
    }

    public void createMaterial(String name, Integer price) {
        ComponentRegister.getInstance().createMaterial(name, price);
    }

    public void resetView() {
        createMaterialView.reset();
    }
}

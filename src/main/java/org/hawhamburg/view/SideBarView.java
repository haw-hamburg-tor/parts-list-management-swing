package org.hawhamburg.view;

import org.hawhamburg.controller.SideBarController;

import javax.swing.*;

public class SideBarView extends JPanel {

    private static final int LEFT_MARGIN = 20;
    private static final int TOP_MARGIN = 20;
    private static final int RIGHT_MARGIN = 20;
    private static final int FRAME_HEIGHT = 720;
    private static final int BUTTON_WIDTH = 140;
    private static final int BUTTON_HEIGHT = 30;
    private static final int BUTTON_Y_MARGIN = 20;

    private final SideBarController sideBarController;

    SideBarView(MainView mainView) {
        sideBarController = new SideBarController(this, mainView);

        var componentOverviewMenuButton = new JButton("Overview");
        componentOverviewMenuButton.setBounds(LEFT_MARGIN, computeButtonYPosition(0), BUTTON_WIDTH, BUTTON_HEIGHT);
        componentOverviewMenuButton.addActionListener(l -> sideBarController.showComponentOverviewView());

        var createMaterialMenuButton = new JButton("Create Material");
        createMaterialMenuButton.setBounds(LEFT_MARGIN, computeButtonYPosition(1), BUTTON_WIDTH, BUTTON_HEIGHT);
        createMaterialMenuButton.addActionListener(l -> sideBarController.showCreateMaterialView());

        var createProductMenuButton = new JButton("Create Product");
        createProductMenuButton.setBounds(LEFT_MARGIN, computeButtonYPosition(2), BUTTON_WIDTH, BUTTON_HEIGHT);
        createProductMenuButton.addActionListener(l -> sideBarController.showCreateProductView());

        var materialListMenuButton = new JButton("Material List");
        materialListMenuButton.setBounds(LEFT_MARGIN, computeButtonYPosition(3), BUTTON_WIDTH, BUTTON_HEIGHT);
        materialListMenuButton.addActionListener(l -> sideBarController.showMaterialListView());

        add(componentOverviewMenuButton);
        add(createMaterialMenuButton);
        add(createProductMenuButton);
        add(materialListMenuButton);

        setBounds(0, 0, LEFT_MARGIN+BUTTON_WIDTH+RIGHT_MARGIN, FRAME_HEIGHT);
        setLayout(null);
    }

    private static int computeButtonYPosition(int buttonIndex) {
        return TOP_MARGIN + buttonIndex * (BUTTON_HEIGHT+BUTTON_Y_MARGIN);
    }
}

package org.hawhamburg.view;

import javax.swing.*;

public class MainView extends JFrame {

    private final SideBarView sideBarView;
    private final ComponentOverviewView componentOverviewView;
    private final CreateMaterialView createMaterialView;
    private final CreateProductView createProductView;
    private final MaterialListView materialListView;

    public MainView() {
        super("parts-list-management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        sideBarView = new SideBarView(this);
        componentOverviewView = new ComponentOverviewView();
        createMaterialView = new CreateMaterialView();
        createProductView = new CreateProductView();
        materialListView = new MaterialListView();

        add(sideBarView);
        add(componentOverviewView);

        pack();
        setSize(1280, 720);
        setVisible(true);
    }

    public void showComponentOverviewView() {
        getContentPane().remove(1);
        add(componentOverviewView);
        repaint();
        setVisible(true);
    }
    public void showCreateMaterialView() {
        getContentPane().remove(1);
        add(createMaterialView);
        repaint();
        setVisible(true);
    }
    public void showCreateProductView() {
        getContentPane().remove(1);
        add(createProductView);
        repaint();
        setVisible(true);
    }
    public void showMaterialListView() {
        getContentPane().remove(1);
        add(materialListView);
        repaint();
        setVisible(true);
    }

}

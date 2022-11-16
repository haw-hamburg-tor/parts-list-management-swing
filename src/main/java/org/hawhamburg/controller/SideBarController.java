package org.hawhamburg.controller;

import org.hawhamburg.view.MainView;
import org.hawhamburg.view.SideBarView;

public class SideBarController {

    private final SideBarView sideBarView;
    private final MainView mainView;

    public SideBarController(SideBarView sideBarView, MainView mainView) {
        this.sideBarView = sideBarView;
        this.mainView = mainView;
    }

    public void showComponentOverviewView() {
        mainView.showComponentOverviewView();
    }

    public void showCreateMaterialView() {
        mainView.showCreateMaterialView();
    }

    public void showCreateProductView() {
        mainView.showCreateProductView();
    }

    public void showMaterialListView() {
        mainView.showMaterialListView();
    }
}

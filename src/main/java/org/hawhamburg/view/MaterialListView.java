package org.hawhamburg.view;

import org.hawhamburg.controller.MaterialListController;

import javax.swing.*;
import java.util.Vector;

public class MaterialListView extends JPanel {
    private final MaterialListController materialListController;

    private final JComboBox<String> nameComboBox;
    private final NameAmountTableModel tableModel;

    private static final int ELEMENT_HEIGHT = 30;

    private static final int NAME_LABEL_X = 500;
    private static final int NAME_LABEL_Y = 100;
    private static final int NAME_LABEL_WIDTH = 60;
    private static final int NAME_LABEL_HEIGHT = ELEMENT_HEIGHT;

    private static final int NAME_COMBO_BOX_X = NAME_LABEL_X + NAME_LABEL_WIDTH + 20;
    private static final int NAME_COMBO_BOX_Y = NAME_LABEL_Y;
    private static final int NAME_COMBO_BOX_WIDTH = 135;
    private static final int NAME_COMBO_BOX_HEIGHT = ELEMENT_HEIGHT;

    private static final int MATERIAL_LIST_BUTTON_X = NAME_COMBO_BOX_X + NAME_COMBO_BOX_WIDTH + 20;
    private static final int MATERIAL_LIST_BUTTON_Y = NAME_LABEL_Y;
    private static final int MATERIAL_LIST_BUTTON_WIDTH = 160;
    private static final int MATERIAL_LIST_BUTTON_HEIGHT = ELEMENT_HEIGHT;

    private static final int TABLE_X = 500;
    private static final int TABLE_Y = 200;
    private static final int TABLE_WIDTH = 400;
    private static final int TABLE_HEIGHT = 300;

    MaterialListView() {
        this.materialListController = new MaterialListController(this);
        setLayout(null);

        var nameLabel = new JLabel("Product:");
        nameLabel.setBounds(NAME_LABEL_X, NAME_LABEL_Y, NAME_LABEL_WIDTH, NAME_LABEL_HEIGHT);

        var nameComboBoxItems = materialListController.getProductNames();
        nameComboBox = new JComboBox<>(nameComboBoxItems);
        nameComboBox.setBounds(NAME_COMBO_BOX_X, NAME_COMBO_BOX_Y, NAME_COMBO_BOX_WIDTH, NAME_COMBO_BOX_HEIGHT);

        var materialListButton = new JButton("Get Material List");
        materialListButton.setBounds(MATERIAL_LIST_BUTTON_X, MATERIAL_LIST_BUTTON_Y, MATERIAL_LIST_BUTTON_WIDTH, MATERIAL_LIST_BUTTON_HEIGHT);
        materialListButton.addActionListener(l -> materialListController.fetchMaterialList((String) nameComboBox.getSelectedItem()));

        tableModel = new NameAmountTableModel();
        var table = new JTable(tableModel);
        var tablePane = new JScrollPane(table);
        tablePane.setBounds(TABLE_X, TABLE_Y, TABLE_WIDTH, TABLE_HEIGHT);
        table.setFillsViewportHeight(true);

        add(nameLabel);
        add(nameComboBox);
        add(materialListButton);
        add(tablePane);
        setVisible(true);
    }

    public void addNameToNameComboBox(String name) {
        nameComboBox.addItem(name);
    }

    public void setMaterialListEntries(Vector<String > names, Vector<Integer> amounts) {
        tableModel.setEntries(names, amounts);
    }

    public void setProductNameComboBoxItems(Vector<String> productNames) {
        nameComboBox.removeAllItems();
        productNames.forEach(nameComboBox::addItem);
    }
}

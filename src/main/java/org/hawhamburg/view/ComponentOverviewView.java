package org.hawhamburg.view;

import org.hawhamburg.controller.ComponentOverviewController;
import org.hawhamburg.model.composite.Component;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class ComponentOverviewView extends JPanel {

    private final ComponentOverviewController componentOverviewController;
    private final ComponentOverviewTableModel tableModel;
    public void addComponent(Component component) {
        tableModel.addComponent(component);
    }

    public void addComponents(List<Component> components) {
        tableModel.addComponents(components);
    }

    static class ComponentOverviewTableModel extends AbstractTableModel {

        private static final List<String> COLUMN_NAMES = List.of("Name", "Price", "Total Price", "Type");
        private Vector<Component> data;

        ComponentOverviewTableModel() {
            this.data = new Vector<>();
        }

        @Override
        public String getColumnName(int column) {
            return COLUMN_NAMES.get(column);
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return COLUMN_NAMES.size();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var component = data.get(rowIndex);
            return switch (columnIndex) {
                case 0 -> component.getName();
                case 1 -> component.getPrice();
                case 2 -> component.fetchTotalPrice();
                case 3 -> component.getType();
                default -> null;
            };
        }

        public void reset() {
            data = new Vector<>();
        }

        public void addComponent(Component component) {
            this.data.add(component);
        }
        public void addComponents(List<Component> components) {
            this.data.addAll(components);
        }
    }
    ComponentOverviewView() {
        this.componentOverviewController = new ComponentOverviewController(this);
        setLayout(null);

        this.tableModel = new ComponentOverviewTableModel();
        componentOverviewController.initializeComponentTable();
        var componentTable = new JTable(tableModel);
        var tablePane = new JScrollPane(componentTable);
        tablePane.setBounds(300, 100, 800, 400);
        componentTable.setFillsViewportHeight(true);

        add(tablePane);
        setVisible(true);
    }

    public void resetTable() {
        tableModel.reset();
    }



}

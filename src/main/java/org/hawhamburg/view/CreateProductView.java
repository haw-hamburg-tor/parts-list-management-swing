package org.hawhamburg.view;

import org.hawhamburg.controller.CreateProductController;

import javax.swing.*;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreateProductView extends JPanel {

    private final CreateProductController createProductController;

    private final JComboBox<String> componentNameComboBox;
    private final NameAmountTableModel tableModel;

    private static final int X_POSITION = 200;
    private static final int TOP_MARGIN = 100;
    private static final int LEFT_MARGIN = 20;
    private static final int ELEMENT_HEIGHT = 30;
    private static final int ELEMENT_WIDTH = 120;
    private static final int INTER_ELEMENT_X_MARGIN = 50;
    private static final int INTER_ELEMENT_Y_MARGIN = 50;

    private static final int NAME_LABEL_X = X_POSITION + LEFT_MARGIN * 9 + 5;
    private static final int NAME_LABEL_Y = TOP_MARGIN;
    private static final int NAME_LABEL_WIDTH = ELEMENT_WIDTH / 2;
    private static final int NAME_LABEL_HEIGHT = ELEMENT_HEIGHT;

    private static final int NAME_TEXT_FIELD_X = NAME_LABEL_X + NAME_LABEL_WIDTH + INTER_ELEMENT_X_MARGIN;
    private static final int NAME_TEXT_FIELD_Y = TOP_MARGIN;
    private static final int NAME_TEXT_FIELD_WIDTH = ELEMENT_WIDTH;
    private static final int NAME_TEXT_FIELD_HEIGHT = ELEMENT_HEIGHT;

    private static final int PRICE_LABEL_X = NAME_TEXT_FIELD_X + NAME_TEXT_FIELD_WIDTH + INTER_ELEMENT_X_MARGIN;
    private static final int PRICE_LABEL_Y = NAME_LABEL_Y;
    private static final int PRICE_LABEL_WIDTH = ELEMENT_WIDTH / 2;
    private static final int PRICE_LABEL_HEIGHT = ELEMENT_HEIGHT;

    private static final int PRICE_COMBO_BOX_X = PRICE_LABEL_X + PRICE_LABEL_WIDTH + INTER_ELEMENT_X_MARGIN;
    private static final int PRICE_COMBO_BOX_Y = PRICE_LABEL_Y;
    private static final int PRICE_COMBO_BOX_WIDTH = ELEMENT_WIDTH;
    private static final int PRICE_COMBO_BOX_HEIGHT = ELEMENT_HEIGHT;

    private static final int COMPONENT_NAME_LABEL_X = X_POSITION + LEFT_MARGIN;
    private static final int COMPONENT_NAME_LABEL_Y = PRICE_LABEL_Y + 100;
    private static final int COMPONENT_NAME_LABEL_WIDTH = ELEMENT_WIDTH;
    private static final int COMPONENT_NAME_LABEL_HEIGHT = ELEMENT_HEIGHT;

    private static final int COMPONENT_NAME_COMBO_BOX_X = COMPONENT_NAME_LABEL_X + COMPONENT_NAME_LABEL_WIDTH;
    private static final int COMPONENT_NAME_COMBO_BOX_Y = COMPONENT_NAME_LABEL_Y;
    private static final int COMPONENT_NAME_COMBO_BOX_WIDTH = ELEMENT_WIDTH;
    private static final int COMPONENT_NAME_COMBO_BOX_HEIGHT = ELEMENT_HEIGHT;

    private static final int COMPONENT_AMOUNT_LABEL_X = COMPONENT_NAME_LABEL_X;
    private static final int COMPONENT_AMOUNT_LABEL_Y = COMPONENT_NAME_LABEL_Y + INTER_ELEMENT_Y_MARGIN;
    private static final int COMPONENT_AMOUNT_LABEL_WIDTH = ELEMENT_WIDTH;
    private static final int COMPONENT_AMOUNT_LABEL_HEIGHT = ELEMENT_HEIGHT;

    private static final int COMPONENT_AMOUNT_COMBO_BOX_X = COMPONENT_NAME_COMBO_BOX_X;
    private static final int COMPONENT_AMOUNT_COMBO_BOX_Y = COMPONENT_AMOUNT_LABEL_Y;
    private static final int COMPONENT_AMOUNT_COMBO_BOX_WIDTH = ELEMENT_WIDTH;
    private static final int COMPONENT_AMOUNT_COMBO_BOX_HEIGHT = ELEMENT_HEIGHT;

    private static final int ADD_COMPONENT_BUTTON_X = COMPONENT_AMOUNT_LABEL_X;
    private static final int ADD_COMPONENT_BUTTON_Y = COMPONENT_AMOUNT_LABEL_Y + INTER_ELEMENT_Y_MARGIN;
    private static final int ADD_COMPONENT_BUTTON_WIDTH = ELEMENT_WIDTH * 2;
    private static final int ADD_COMPONENT_BUTTON_HEIGHT = ELEMENT_HEIGHT;

    private static final int TABLE_X = 500;
    private static final int TABLE_Y = 200;
    private static final int TABLE_WIDTH = 400;
    private static final int TABLE_HEIGHT = 300;

    private static final int CREATE_BUTTON_X = TABLE_X;
    private static final int CREATE_BUTTON_Y = TABLE_Y + TABLE_HEIGHT + 15;
    private static final int CREATE_BUTTON_WIDTH = TABLE_WIDTH;
    private static final int CREATE_BUTTON_HEIGHT = ELEMENT_HEIGHT;
    private final JTextField nameTextField;
    private final JComboBox<Integer> priceComboBox;
    private final JComboBox<Integer> componentAmountComboBox;

    CreateProductView() {
        this.createProductController = new CreateProductController(this);
        setLayout(null);

        var nameLabel = new JLabel("Name:");
        nameLabel.setBounds(NAME_LABEL_X, NAME_LABEL_Y, NAME_LABEL_WIDTH, NAME_LABEL_HEIGHT);

        nameTextField = new JTextField();
        nameTextField.setBounds(NAME_TEXT_FIELD_X, NAME_TEXT_FIELD_Y, NAME_TEXT_FIELD_WIDTH, NAME_TEXT_FIELD_HEIGHT);

        var priceLabel = new JLabel("Price:");
        priceLabel.setBounds(PRICE_LABEL_X, PRICE_LABEL_Y, PRICE_LABEL_WIDTH, PRICE_LABEL_HEIGHT);

        var priceComboBoxItems = IntStream.range(1, 20).boxed().collect(Collectors.toCollection(Vector::new));
        priceComboBox = new JComboBox<>(priceComboBoxItems);
        priceComboBox.setBounds(PRICE_COMBO_BOX_X, PRICE_COMBO_BOX_Y, PRICE_COMBO_BOX_WIDTH, PRICE_COMBO_BOX_HEIGHT);

        var componentNameLabel = new JLabel("Component Name:");
        componentNameLabel.setBounds(COMPONENT_NAME_LABEL_X, COMPONENT_NAME_LABEL_Y, COMPONENT_NAME_LABEL_WIDTH, COMPONENT_NAME_LABEL_HEIGHT);

        var componentNameComboBoxItems = createProductController.getComponentNames();
        componentNameComboBox = new JComboBox<>(componentNameComboBoxItems);
        componentNameComboBox.setBounds(COMPONENT_NAME_COMBO_BOX_X, COMPONENT_NAME_COMBO_BOX_Y, COMPONENT_NAME_COMBO_BOX_WIDTH, COMPONENT_NAME_COMBO_BOX_HEIGHT);

        var componentAmountLabel = new JLabel("Amount:");
        componentAmountLabel.setBounds(COMPONENT_AMOUNT_LABEL_X, COMPONENT_AMOUNT_LABEL_Y, COMPONENT_AMOUNT_LABEL_WIDTH, COMPONENT_AMOUNT_LABEL_HEIGHT);

        var componentAmountComboBoxItems = IntStream.range(1, 20).boxed().collect(Collectors.toCollection(Vector::new));
        componentAmountComboBox = new JComboBox<>(componentAmountComboBoxItems);
        componentAmountComboBox.setBounds(COMPONENT_AMOUNT_COMBO_BOX_X, COMPONENT_AMOUNT_COMBO_BOX_Y, COMPONENT_AMOUNT_COMBO_BOX_WIDTH, COMPONENT_AMOUNT_COMBO_BOX_HEIGHT);

        var addComponentButton = new JButton("Add Component");
        addComponentButton.setBounds(ADD_COMPONENT_BUTTON_X, ADD_COMPONENT_BUTTON_Y, ADD_COMPONENT_BUTTON_WIDTH, ADD_COMPONENT_BUTTON_HEIGHT);
        addComponentButton.addActionListener(l -> createProductController.addEntryToAddComponentTable(
                (String) componentNameComboBox.getSelectedItem(),
                (Integer) componentAmountComboBox.getSelectedItem())
        );

        this.tableModel = new NameAmountTableModel();
        var addComponentTable = new JTable(tableModel);
        var tablePane = new JScrollPane(addComponentTable);
        tablePane.setBounds(TABLE_X, TABLE_Y, TABLE_WIDTH, TABLE_HEIGHT);
        addComponentTable.setFillsViewportHeight(true);

        var createButton = new JButton("Create Product");
        createButton.setBounds(CREATE_BUTTON_X, CREATE_BUTTON_Y, CREATE_BUTTON_WIDTH, CREATE_BUTTON_HEIGHT);
        createButton.addActionListener(l -> {
                    String name = nameTextField.getText();
                    Integer price = (Integer) priceComboBox.getSelectedItem();
                    createProductController.createProduct(name, price, tableModel.getNames(), tableModel.getAmounts());
                    createProductController.resetView();
                }
        );

        add(nameLabel);
        add(nameTextField);
        add(priceLabel);
        add(priceComboBox);
        add(componentNameLabel);
        add(componentNameComboBox);
        add(componentAmountLabel);
        add(componentAmountComboBox);
        add(addComponentButton);
        add(tablePane);
        add(createButton);
        setVisible(true);
    }

    public void addNameToComponentNameComboBox(String name) {
        componentNameComboBox.addItem(name);
    }

    public void addEntryToAddComponentTable(String name, Integer amount) {
        tableModel.addEntry(name, amount);
    }

    public void reset() {
        nameTextField.setText("");
        priceComboBox.setSelectedIndex(0);
        componentNameComboBox.setSelectedIndex(0);
        componentAmountComboBox.setSelectedIndex(0);
        tableModel.removeAll();
    }
}

package org.hawhamburg.view;

import org.hawhamburg.controller.CreateMaterialController;

import javax.swing.*;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreateMaterialView extends JPanel {

    private final CreateMaterialController createMaterialController;

    private final JTextField nameTextField;
    private final JComboBox<Integer> priceComboBox;

    private static final int X_POSITION = 180;
    private static final int TOP_MARGIN = 100;
    private static final int LEFT_MARGIN = 200;
    private static final int ELEMENT_HEIGHT = 30;
    private static final int ELEMENT_WIDTH = 200;
    private static final int INTER_ELEMENT_X_MARGIN = 50;
    private static final int INTER_ELEMENT_Y_MARGIN = 50;

    private static final int NAME_LABEL_X = X_POSITION + LEFT_MARGIN;
    private static final int NAME_LABEL_Y = TOP_MARGIN;
    private static final int NAME_LABEL_WIDTH = ELEMENT_WIDTH;
    private static final int NAME_LABEL_HEIGHT = ELEMENT_HEIGHT;

    private static final int NAME_TEXT_FIELD_X = NAME_LABEL_X + NAME_LABEL_WIDTH + INTER_ELEMENT_X_MARGIN;
    private static final int NAME_TEXT_FIELD_Y = TOP_MARGIN;
    private static final int NAME_TEXT_FIELD_WIDTH = ELEMENT_WIDTH;
    private static final int NAME_TEXT_FIELD_HEIGHT = ELEMENT_HEIGHT;

    private static final int PRICE_LABEL_X = NAME_LABEL_X;
    private static final int PRICE_LABEL_Y = NAME_LABEL_Y + NAME_LABEL_HEIGHT + INTER_ELEMENT_Y_MARGIN;
    private static final int PRICE_LABEL_WIDTH = ELEMENT_WIDTH;
    private static final int PRICE_LABEL_HEIGHT = ELEMENT_HEIGHT;

    private static final int PRICE_COMBO_BOX_X = NAME_TEXT_FIELD_X;
    private static final int PRICE_COMBO_BOX_Y = PRICE_LABEL_Y;
    private static final int PRICE_COMBO_BOX_WIDTH = ELEMENT_WIDTH;
    private static final int PRICE_COMBO_BOX_HEIGHT = ELEMENT_HEIGHT;

    private static final int CREATE_BUTTON_X = PRICE_COMBO_BOX_X;
    private static final int CREATE_BUTTON_Y = PRICE_COMBO_BOX_Y + PRICE_COMBO_BOX_HEIGHT + INTER_ELEMENT_Y_MARGIN;
    private static final int CREATE_BUTTON_WIDTH = ELEMENT_WIDTH;
    private static final int CREATE_BUTTON_HEIGHT = ELEMENT_HEIGHT;


    CreateMaterialView() {
        this.createMaterialController = new CreateMaterialController(this);
        setLayout(null);

        var nameLabel = new JLabel("Name:");
        nameLabel.setBounds(NAME_LABEL_X, NAME_LABEL_Y, NAME_LABEL_WIDTH, NAME_LABEL_HEIGHT);

        nameTextField = new JTextField();
        nameTextField.setBounds(NAME_TEXT_FIELD_X, NAME_TEXT_FIELD_Y, NAME_TEXT_FIELD_WIDTH, NAME_TEXT_FIELD_HEIGHT);

        var priceLabel = new JLabel("Price:");
        priceLabel.setBounds(PRICE_LABEL_X, PRICE_LABEL_Y, PRICE_LABEL_WIDTH, PRICE_LABEL_HEIGHT);

        var comboBoxItems = IntStream.range(1, 20).boxed().collect(Collectors.toCollection(Vector::new));
        priceComboBox = new JComboBox<>(comboBoxItems);
        priceComboBox.setBounds(PRICE_COMBO_BOX_X, PRICE_COMBO_BOX_Y, PRICE_COMBO_BOX_WIDTH, PRICE_COMBO_BOX_HEIGHT);

        var createButton = new JButton("Create");
        createButton.setBounds(CREATE_BUTTON_X, CREATE_BUTTON_Y, CREATE_BUTTON_WIDTH, CREATE_BUTTON_HEIGHT);
        createButton.addActionListener(l -> {
            createMaterialController.createMaterial(nameTextField.getText(), (Integer) priceComboBox.getSelectedItem());
            createMaterialController.resetView();
        });

        add(nameLabel);
        add(nameTextField);
        add(priceLabel);
        add(priceComboBox);
        add(createButton);
        setVisible(true);
    }

    public void reset() {
        nameTextField.setText("");
        priceComboBox.setSelectedIndex(0);
    }
}

package com.bank.views;

import com.bank.config.ATMconstats;
import com.bank.ui.*;
import com.bank.ui.Button;
import com.bank.ui.Label;
import com.bank.views.addPanel.RawPanelOneItem;
import com.bank.views.addPanel.RawPanelTwoItems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


/**
 * A panel that represents the "Add Entity" page of the application.
 * <p>
 * This class extends {@link JPanel} and provides the foundation
 * for adding entities in the system. Currently, it includes
 * a title label displaying "Add Entity".
 * </p>
 */
public class AddEntityPanel extends JPanel {
    String[] list = {"ATM", "Customer"};
    ComboBox comboBox;

    ScrollPanel scrollPanel;


    public AddEntityPanel() {
        comboBox = new ComboBox(list);
        scrollPanel = new ScrollPanel();

        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        this.add(new RawPanelOneItem<Header>(new Header("Add Entity")));
        this.add(new RawPanelTwoItems<Label, ComboBox>(new Label("Entity Type"), comboBox));
        this.add(new RawPanelOneItem<JButton>(new Button("OK")));
        this.add(scrollPanel);

        comboBox.addActionListener(e -> {
            String itemSelected = comboBox.getSelectedItem().toString();
            if (itemSelected.equals("ATM")) {
                showAtmAttribute();
            } else if (itemSelected.equals("Customer")) {
                System.out.println("Customer");
                /*
                 * function to add the whole attributes of Customer Entity
                 * */
            }
        });
    }

    public void showAtmAttribute() {
        for (RawPanelTwoItems atmAttribute : ATMconstats.Attributes) {
            javax.swing.SwingUtilities.invokeLater(() -> {
                scrollPanel.add(atmAttribute);
            });
        }
    }

}

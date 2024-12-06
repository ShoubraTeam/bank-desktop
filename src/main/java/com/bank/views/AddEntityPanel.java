package com.bank.views;

import com.bank.ui.Button;
import com.bank.ui.ComboBox;
import com.bank.ui.Header;
import com.bank.ui.Label;
import com.bank.views.addPanel.RawPanelOneItem;
import com.bank.views.addPanel.RawPanelTwoItems;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public AddEntityPanel() {
        comboBox = new ComboBox(list);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        this.add(new RawPanelOneItem<Header>(new Header("Add Entity")));
        this.add(new RawPanelTwoItems<Label,ComboBox>(new Label("Entity Type"),new ComboBox(list)));
        this.add(new RawPanelOneItem<JButton>(new Button("OK")));
        /*
        * add scroll panel to add on it the rest of the fields
        * */
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemSelected = comboBox.getSelectedItem().toString();
                if (itemSelected.equals("ATM")) {
                    System.out.println("ATM");
                    /*
                    * function to add the whole attributes of ATM Entity
                    * */
                } else if (itemSelected.equals("Customer")) {
                    System.out.println("Customer");
                    /*
                     * function to add the whole attributes of Customer Entity
                     * */
                }
            }
        });
    }

}

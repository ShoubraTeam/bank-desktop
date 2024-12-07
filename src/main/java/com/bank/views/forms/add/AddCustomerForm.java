package com.bank.views.forms.add;

import com.bank.config.Colors;
import com.bank.config.EntityConstants;
import com.bank.ui.Button;
import com.bank.ui.ComboBox;
import com.bank.ui.Label;
import com.bank.utils.Helpers;
import com.bank.views.forms.Form;
import com.bank.views.forms.RowPanelOneItem;
import com.bank.views.forms.RowPanelTwoItems;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class AddCustomerForm extends Form {
    private ComboBox branchComboBox;
    private JPanel formPanel;

    public AddCustomerForm() {
        Button submitBtn = new Button("Submit");
        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(10, 1, 12, 12));
        formPanel.setBorder(new EmptyBorder(18, 18, 18, 18));

        this.setLayout(new BorderLayout(12, 12));
        branchComboBox = new ComboBox(new String[]{});
        formPanel.add(new RowPanelTwoItems<Label, ComboBox>(new Label("Branch ID"), branchComboBox));
        for (RowPanelTwoItems row : EntityConstants.CUSTOMER_ADD_ATTRIBUTES) {
            formPanel.add(row);
        }

        JScrollPane scrollPane = new JScrollPane(formPanel);
        scrollPane.setPreferredSize(new Dimension(500, 600));
        scrollPane.setBorder(new MatteBorder(3, 3, 3, 3, Colors.SECONDARY_COLOR));
        this.add(scrollPane, BorderLayout.CENTER);

        submitBtn.addActionListener(submit());
        this.add(new RowPanelOneItem<>(submitBtn), BorderLayout.SOUTH);
    }

    public ActionListener submit() {
        return (e) -> {
            ArrayList<String> values = Helpers.getValuesFromInputs(EntityConstants.CUSTOMER_ADD_ATTRIBUTES);
            values.addFirst(branchComboBox.getSelectedItem().toString());
            // TODO: ADD YOUR SQL CODE HERE
            System.out.println(Arrays.toString(values.toArray()));
        };
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        branchComboBox.removeAllItems();
        // TODO: GET BRANCHES HERE
    }
}

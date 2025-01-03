package com.bank.views.forms.modify;

import com.bank.config.Colors;
import com.bank.config.EntityConstants;
import com.bank.config.TablesName;
import com.bank.services.QueryServices;
import com.bank.ui.Button;
import com.bank.utils.Helpers;
import com.bank.views.forms.Form;
import com.bank.views.forms.RowPanelOneItem;
import com.bank.views.forms.RowPanelTwoItems;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;

public class ModifyCustomerForm extends Form {
    public ModifyCustomerForm() {
        Button submitBtn = new Button("Submit");
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(10, 1, 12, 12));
        formPanel.setBorder(new EmptyBorder(18, 18, 18, 18));

        this.setLayout(new BorderLayout(12, 12));
        for (RowPanelTwoItems row : EntityConstants.CUSTOMER_MODIFY_ATTRIBUTES) {
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
            LinkedHashMap<String, Object> values = Helpers.getValuesFromInputsModify(EntityConstants.CUSTOMER_MODIFY_ATTRIBUTES);
            QueryServices.update(values, TablesName.CUSTOMER);
        };
    }
}

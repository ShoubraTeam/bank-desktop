package com.bank.views.forms.delete;

import com.bank.config.Colors;
import com.bank.config.EntityConstants;
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
import java.util.ArrayList;
import java.util.Arrays;

public class DeleteLoanForm extends Form {
    public DeleteLoanForm() {
        Button submitBtn = new Button("Delete");
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(10, 1, 12, 12));
        formPanel.setBorder(new EmptyBorder(18, 18, 18, 18));

        this.setLayout(new BorderLayout(12, 12));
        for (RowPanelTwoItems row : EntityConstants.LOAN_DELETE_ATTRIBUTES) {
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
            ArrayList<String> values = Helpers.getValuesFromInputs(EntityConstants.LOAN_DELETE_ATTRIBUTES);
            // ADD YOUR CODE HERE
            System.out.println(Arrays.toString(values.toArray()));
        };
    }
}

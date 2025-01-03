package com.bank.views.forms.add;

import com.bank.config.Colors;
import com.bank.config.EntityConstants;
import com.bank.controllers.ATMController;
import com.bank.controllers.BankAccountController;
import com.bank.controllers.TransactionsController;
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
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddTransactionForm extends Form {
    private ComboBox atmIdComboBox;
    private ComboBox accountIdComboBox;
    private JPanel formPanel;

    public AddTransactionForm() {
        Button submitBtn = new Button("Submit");
        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(10, 1, 12, 12));
        formPanel.setBorder(new EmptyBorder(18, 18, 18, 18));

        this.setLayout(new BorderLayout(12, 12));
        atmIdComboBox = new ComboBox(new String[]{});
        accountIdComboBox = new ComboBox(new String[]{});
        formPanel.add(new RowPanelTwoItems<Label, ComboBox>(new Label("ATM ID"), atmIdComboBox));
        formPanel.add(new RowPanelTwoItems<Label, ComboBox>(new Label("Account ID"), accountIdComboBox));
        for (RowPanelTwoItems row : EntityConstants.TRANSACTION_ADD_ATTRIBUTES) {
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
            ArrayList<String> values = Helpers.getValuesFromInputs(EntityConstants.TRANSACTION_ADD_ATTRIBUTES);
            values.addFirst(accountIdComboBox.getSelectedItem().toString());
            values.addFirst(atmIdComboBox.getSelectedItem().toString());
            TransactionsController.add(values);
        };
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        atmIdComboBox.removeAllItems();
        accountIdComboBox.removeAllItems();
        for (String id : ATMController.getAllIds()) {
            atmIdComboBox.addItem(id);
        }
        for (String id : BankAccountController.getAllIds()) {
            accountIdComboBox.addItem(id);
        }
    }
}

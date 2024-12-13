package com.bank.views.forms.add;

import com.bank.config.Colors;
import com.bank.config.EntityConstants;
import com.bank.controllers.ATMController;
import com.bank.controllers.BankAccountController;
import com.bank.controllers.BranchController;
import com.bank.controllers.TransfersController;
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
import java.util.Arrays;

public class AddTransfersForm extends Form {
    private ComboBox branchIdComboBox;
    private ComboBox senderIdComboBox;
    private ComboBox receiverIdComboBox;
    private JPanel formPanel;

    public AddTransfersForm() {
        Button submitBtn = new Button("Submit");
        formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(10, 1, 12, 12));
        formPanel.setBorder(new EmptyBorder(18, 18, 18, 18));

        this.setLayout(new BorderLayout(12, 12));
        branchIdComboBox = new ComboBox(new String[]{});
        senderIdComboBox = new ComboBox(new String[]{});
        receiverIdComboBox = new ComboBox(new String[]{});
        formPanel.add(new RowPanelTwoItems<Label, ComboBox>(new Label("Branch ID"), branchIdComboBox));
        formPanel.add(new RowPanelTwoItems<Label, ComboBox>(new Label("Sender ID"), senderIdComboBox));
        formPanel.add(new RowPanelTwoItems<Label, ComboBox>(new Label("Receiver ID"), receiverIdComboBox));
        for (RowPanelTwoItems row : EntityConstants.TRANSFER_ADD_ATTRIBUTES) {
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
            ArrayList<String> values = Helpers.getValuesFromInputs(EntityConstants.TRANSFER_ADD_ATTRIBUTES);
            values.addFirst(receiverIdComboBox.getSelectedItem().toString());
            values.addFirst(senderIdComboBox.getSelectedItem().toString());
            values.addFirst(branchIdComboBox.getSelectedItem().toString());
            TransfersController.add(values);
        };
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        branchIdComboBox.removeAllItems();
        senderIdComboBox.removeAllItems();
        receiverIdComboBox.removeAllItems();
        for (String id : BranchController.getAllIds()) {
            branchIdComboBox.addItem(id);
        }
        for (String id : BankAccountController.getAllIds()) {
            senderIdComboBox.addItem(id);
        }
        for (String id : BankAccountController.getAllIds()) {
            receiverIdComboBox.addItem(id);
        }
    }
}

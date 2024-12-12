package com.bank.views.forms.modify;

import com.bank.config.Colors;
import com.bank.config.EntityConstants;
import com.bank.ui.Button;
import com.bank.utils.Helpers;
import com.bank.utils.HashMapPair;
import com.bank.views.forms.Form;
import com.bank.views.forms.RowPanelOneItem;
import com.bank.views.forms.RowPanelThreeItems;
import com.bank.views.forms.RowPanelTwoItems;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ModifyATMFrom extends Form {

    public ModifyATMFrom() {
        Button submitBtn = new Button("Submit");
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(10, 1, 12, 12));
        formPanel.setBorder(new EmptyBorder(18, 18, 18, 18));

        this.setLayout(new BorderLayout(12, 12));

        for (RowPanelTwoItems row : EntityConstants.ATM_MODIFY_ATTRIBUTES) {
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
            HashMapPair linkedListPair = Helpers.getValuesFromInputsModify((RowPanelThreeItems<?, ?, ?>[]) EntityConstants.ATM_MODIFY_ATTRIBUTES);
            // ADD YOUR CODE HERE
            //first list contain the values that we put in update sentence
            System.out.println(Arrays.toString(linkedListPair.getFirstList().keySet().toArray()));
            System.out.println(Arrays.toString(linkedListPair.getFirstList().values().toArray()));
            System.out.println();
            //second list contain the values that we put in the where condition
            System.out.println(Arrays.toString(linkedListPair.getSecondList().keySet().toArray()));
            System.out.println(Arrays.toString(linkedListPair.getSecondList().values().toArray()));
        };
    }
}

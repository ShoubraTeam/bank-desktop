package com.bank.utils;

import com.bank.views.forms.RowPanelTwoItems;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Helpers {
    // add padding - got from chatgpt
    public static DefaultListCellRenderer addPaddingToComboBox() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(
                    JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Add padding: top, left, bottom, right
                return label;
            }
        };
    }

    public static ArrayList<String> getValuesFromInputs(RowPanelTwoItems<?,?>[] attrs) {
        ArrayList<String> values = new ArrayList<>();

        for (RowPanelTwoItems<?,?> row : attrs) {
            String value;
            if (row.getSecondComponent() instanceof JTextField) {
                value = ((JTextField) row.getSecondComponent()).getText();
            } else if (row.getSecondComponent() instanceof JCheckBox) {
                value = String.valueOf(((JCheckBox) row.getSecondComponent()).isSelected());
            } else {
                value = ((JComboBox<?>) row.getSecondComponent()).getSelectedItem().toString();
            }
            values.add(value);
        }

        return values;
    }
}

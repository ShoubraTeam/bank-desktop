package com.bank.utils;

import com.bank.ui.CheckBox;
import com.bank.views.forms.RowPanelThreeItems;
import com.bank.views.forms.RowPanelTwoItems;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

    public static ArrayList<String> getValuesFromInputs(RowPanelTwoItems<?, ?>[] attrs) {
        ArrayList<String> values = new ArrayList<>();

        for (RowPanelTwoItems<?, ?> row : attrs) {
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

    public static LinkedHashMap<String, Object> getValuesFromInputsModify(RowPanelThreeItems<?, ?, ?>[] attrs) {
        LinkedHashMap<String, Object> values = new LinkedHashMap<>();
        int count = 0;
        Object value;
        String key;
        for (RowPanelThreeItems<?, ?, ?> row : attrs) {
            if (count == 0) {
                value = ((JTextField) row.getSecondComponent()).getText();
                key = ((JLabel) row.getFirstComponent()).getText();
                values.put(key, value);
                count++;
            } else {
                if (row.getThirdComponent() instanceof CheckBox) {
                    if (((CheckBox) row.getThirdComponent()).isSelected()) {
                        if (row.getSecondComponent() instanceof JTextField) {
                            value = ((JTextField) row.getSecondComponent()).getText();
                            key = ((JLabel) row.getFirstComponent()).getText();
                            values.put(key, value);
                        } else if (row.getSecondComponent() instanceof JCheckBox) {
                            value = String.valueOf(((JCheckBox) row.getSecondComponent()).isSelected());
                            key = ((JLabel) row.getFirstComponent()).getText();
                            values.put(key, value);
                        }
                    }
                }
            }
        }
        return values;
    }


}

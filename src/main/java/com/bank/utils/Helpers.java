package com.bank.utils;

import com.bank.config.EntityConstants;
import com.bank.ui.CheckBoxPanel;
import com.bank.views.forms.RowPanelOneItem;
import com.bank.views.forms.RowPanelThreeItems;
import com.bank.views.forms.RowPanelTwoItems;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

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

    public static HashMapPair getValuesFromInputsModify(RowPanelThreeItems<?, ?, ?>[] attrs) {
        HashMap<String,String> values = new HashMap<String,String>();
        HashMap<String,String> wherevalues = new HashMap<String,String>();

        for (RowPanelThreeItems<?, ?, ?> row : attrs) {
            String value;
            String key;
            if (row.getThirdComponent() instanceof CheckBoxPanel<?, ?>) {

                Enumeration<AbstractButton> buttons = ((CheckBoxPanel<?, ?>) row.getThirdComponent()).getGroup().getElements();
                while (buttons.hasMoreElements()) {
                    JRadioButton button = (JRadioButton) buttons.nextElement();
                    if (button.isSelected()) {
                        if (EntityConstants.CheckBoxesModifyConstants[1].equals(button.getText())) {
                            if (row.getSecondComponent() instanceof JTextField) {
                                value = ((JTextField) row.getSecondComponent()).getText();
                                key=((JLabel) row.getFirstComponent()).getText();
                            } else if (row.getSecondComponent() instanceof JCheckBox) {
                                value = String.valueOf(((JCheckBox) row.getSecondComponent()).isSelected());
                                key=((JLabel) row.getFirstComponent()).getText();
                            } else {
                                value = ((JComboBox<?>) row.getSecondComponent()).getSelectedItem().toString();
                                key=((JLabel) row.getFirstComponent()).getText();
                            }
                            values.put(key,value);
                        } else if (EntityConstants.CheckBoxesModifyConstants[0].equals(button.getText())) {
                            if (row.getSecondComponent() instanceof JTextField) {
                                value = ((JTextField) row.getSecondComponent()).getText();
                                key=((JLabel) row.getFirstComponent()).getText();
                            } else if (row.getSecondComponent() instanceof JCheckBox) {
                                value = String.valueOf(((JCheckBox) row.getSecondComponent()).isSelected());
                                key=((JLabel) row.getFirstComponent()).getText();
                            } else {
                                value = ((JComboBox<?>) row.getSecondComponent()).getSelectedItem().toString();
                                key=((JLabel) row.getFirstComponent()).getText();
                            }
                            wherevalues.put(key,value);
                        }

                    }
                }

            } else if (row.getThirdComponent() instanceof RowPanelOneItem<?>) {

                Enumeration<AbstractButton> buttons = ((RowPanelOneItem<?>) row.getThirdComponent()).getComponentIfRadioButton().getElements();
                while (buttons.hasMoreElements()) {
                    JRadioButton button = (JRadioButton) buttons.nextElement();
                    if (button.isSelected()) {
                        if (EntityConstants.CheckBoxesModifyConstants[0].equals(button.getText())) {
                            if (row.getSecondComponent() instanceof JTextField) {
                                value = ((JTextField) row.getSecondComponent()).getText();
                                key=((JLabel) row.getFirstComponent()).getText();
                            } else if (row.getSecondComponent() instanceof JCheckBox) {
                                value = String.valueOf(((JCheckBox) row.getSecondComponent()).isSelected());
                                key=((JLabel) row.getFirstComponent()).getText();
                            } else {
                                value = ((JComboBox<?>) row.getSecondComponent()).getSelectedItem().toString();
                                key=((JLabel) row.getFirstComponent()).getText();
                            }
                            wherevalues.put(key,value);
                        }

                    }
                }

            }


        }

        return new HashMapPair(values, wherevalues);
    }


}

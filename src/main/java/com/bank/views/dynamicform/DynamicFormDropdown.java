package com.bank.views.dynamicform;

import com.bank.ui.ComboBox;
import com.bank.ui.Label;
import com.bank.views.forms.RowPanelTwoItems;

import java.util.Arrays;

public class DynamicFormDropdown {
    ComboBox comboBox;
    RowPanelTwoItems<Label, ComboBox> row;

    public DynamicFormDropdown(String label, DynamicFormOption[] options) {
        this.comboBox = new ComboBox(Arrays.stream(options).map(DynamicFormOption::getName).toArray(String[]::new));
        this.row = new RowPanelTwoItems<>(new Label(label), this.comboBox);
    }

    public ComboBox getComboBox() {
        return this.comboBox;
    }

    public RowPanelTwoItems<Label, ComboBox> getRow() {
        return this.row;
    }
}

package com.bank.views.forms;

import com.bank.ui.CheckBox;

import javax.swing.*;
import java.awt.*;

public class RowPanelOneItem<T extends Component> extends JPanel {
    public RowPanelOneItem(T object) {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(object);
    }
}

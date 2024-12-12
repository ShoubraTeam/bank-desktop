package com.bank.views.forms;

import com.bank.ui.RadioButton;

import javax.swing.*;
import java.awt.*;

public class RowPanelOneItem<T extends Component> extends JPanel {
    ButtonGroup buttonGroup = new ButtonGroup();

    public RowPanelOneItem(T object) {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(object);
        if (object instanceof RadioButton) {
            buttonGroup = new ButtonGroup();
            buttonGroup.add((RadioButton) object);
        }
    }

    public ButtonGroup getComponentIfRadioButton() {
        return buttonGroup;
    }

}

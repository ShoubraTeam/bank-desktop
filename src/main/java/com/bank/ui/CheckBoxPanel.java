package com.bank.ui;

import javax.swing.*;
import java.awt.*;

public class CheckBoxPanel<T1 extends Component, T2 extends Component> extends JPanel {
    ButtonGroup buttonGroup;
    public CheckBoxPanel(T1 object1, T2 object2) {
        buttonGroup=new ButtonGroup();
        this.setLayout(new FlowLayout(10,10,10));
        this.add(object1);
        this.add(object2);
        buttonGroup.add((RadioButton)object1);
        buttonGroup.add((RadioButton)object2);

    }
    public ButtonGroup getGroup()
    {
        return buttonGroup;
    }

}

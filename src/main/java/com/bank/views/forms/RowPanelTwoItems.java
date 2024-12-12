package com.bank.views.forms;

import javax.swing.*;
import java.awt.*;

public class RowPanelTwoItems<T1 extends Component, T2 extends Component> extends JPanel {
    private T2 object2;
    RowPanelTwoItems()
    {}
    public RowPanelTwoItems(T1 object1, T2 object2) {
        this.setLayout(new BorderLayout(0, 8));
        this.add(object1, BorderLayout.NORTH);
        this.add(object2, BorderLayout.CENTER);
        this.object2 = object2;
    }

    public Component getSecondComponent() {
        return object2;
    }
}
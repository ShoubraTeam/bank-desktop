package com.bank.views.forms;

import javax.swing.*;
import java.awt.*;

public class RowPanelThreeItems<T1 extends Component, T2 extends Component, T3 extends Component> extends RowPanelTwoItems {
    T1 object1;
    T2 object2;
    T3 object3;

    public RowPanelThreeItems(T1 object1, T2 object2, T3 object3) {
        this.setLayout(new BorderLayout(0, 8));
        this.add(object1, BorderLayout.NORTH);
        this.add(object2, BorderLayout.CENTER);
        this.add(object3, BorderLayout.SOUTH);
        this.object1 = object1;
        this.object2 = object2;
        this.object3 = object3;
    }

    public Component getThirdComponent() {
        return object3;
    }
    public Component getFirstComponent() {
        return object1;
    }

    @Override
    public Component getSecondComponent() {
        return object2;
    }
}

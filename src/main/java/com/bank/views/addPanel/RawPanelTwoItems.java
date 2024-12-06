package com.bank.views.addPanel;

import javax.swing.*;
import java.awt.*;

public class RawPanelTwoItems<T1 extends Component, T2 extends Component> extends JPanel {

    public RawPanelTwoItems(T1 object1, T2 object2) {
        this.setPreferredSize(new Dimension(900, 80));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(object1);
        this.add(object2);
    }

}
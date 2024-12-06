package com.bank.views.addPanel;

import javax.swing.*;
import java.awt.*;

public class RawPanelTwoItems<T1, T2> extends JPanel {

    public RawPanelTwoItems(T1 object1, T2 object2) {
        this.setPreferredSize(new Dimension(900, 80));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add((Component) object1);
        this.add((Component) object2);
    }

}
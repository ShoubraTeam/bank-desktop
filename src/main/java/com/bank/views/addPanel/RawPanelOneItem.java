package com.bank.views.addPanel;

import javax.swing.*;
import java.awt.*;

public class RawPanelOneItem<T extends Component> extends JPanel {

    public RawPanelOneItem(T object) {
        this.setPreferredSize(new Dimension(900, 40));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(object);
    }

}

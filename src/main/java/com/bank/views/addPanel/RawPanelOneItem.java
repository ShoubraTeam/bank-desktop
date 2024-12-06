package com.bank.views.addPanel;

import javax.swing.*;
import java.awt.*;

public class RawPanel<T> extends JPanel {

    public RawPanel(T object) {

        this.setPreferredSize(new Dimension(900, 50));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add((Component) object);


    }

}

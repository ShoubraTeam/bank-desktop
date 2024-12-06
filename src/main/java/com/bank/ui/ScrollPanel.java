package com.bank.ui;

import com.bank.config.Colors;

import javax.swing.*;
import java.awt.*;

public class ScrollPanel extends JScrollPane {


    public ScrollPanel()
    {
        this.setPreferredSize(new Dimension(700,200));
        this.setBackground(Colors.TEXT_COLOR);
    }
}

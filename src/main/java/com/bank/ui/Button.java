package com.bank.ui;

import com.bank.config.Colors;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button(String buttonName)
    {
        this.setText(buttonName);
        this.setPreferredSize(new Dimension(103,35));
        this.setBackground(Colors.PRIMARY_COLOR);
        this.setForeground(Colors.SECONDARY_COLOR);
//        this.setFocusable(false);
        this.setRequestFocusEnabled(false);
    }

}



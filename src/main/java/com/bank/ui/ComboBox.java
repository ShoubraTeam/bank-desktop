package com.bank.ui;

import com.bank.config.Colors;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class ComboBox extends JComboBox {
    public ComboBox(String[] list) {
        super(list);
        this.setPreferredSize(new Dimension(890,50));
        this.setBackground(Colors.SECONDARY_COLOR);
        this.setRequestFocusEnabled(false);

        this.setFont(new Font("Arial", Font.BOLD, 18));
    }

}

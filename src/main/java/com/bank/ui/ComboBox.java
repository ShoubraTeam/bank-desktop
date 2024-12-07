package com.bank.ui;

import com.bank.config.Colors;
import com.bank.utils.Helpers;

import javax.swing.*;
import java.awt.*;

public class ComboBox extends JComboBox<String> {
    public ComboBox(String[] list) {
        super(list);
        this.setPreferredSize(new Dimension(0, 50));
        this.setBackground(Colors.SECONDARY_COLOR);
        this.setRequestFocusEnabled(false);
        this.setFont(new Font("Arial", Font.BOLD, 18));
        this.setRenderer(Helpers.addPaddingToComboBox());
    }
}

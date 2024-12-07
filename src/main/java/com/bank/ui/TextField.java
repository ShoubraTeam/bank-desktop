package com.bank.ui;

import com.bank.config.Colors;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class TextField extends JTextField {
    public TextField() {
        this.setBorder(new MatteBorder(2, 2, 2, 2, Colors.BORDER_COLOR)); // add padding
        this.setPreferredSize(new Dimension(0, 50));
        this.setFont(new Font("Arial", Font.BOLD, 18));
    }
}

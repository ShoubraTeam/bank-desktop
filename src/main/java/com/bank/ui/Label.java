package com.bank.ui;

import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    public Label(String text) {
        this(text, SwingConstants.LEFT);
    }

    public Label(String text, int horizontalAlignment) {
        this.setText(text);
        this.setHorizontalAlignment(horizontalAlignment);
        this.setFont(new Font("Arial", Font.BOLD, 24));
    }
}

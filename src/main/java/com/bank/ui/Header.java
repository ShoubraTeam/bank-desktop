package com.bank.ui;

import javax.swing.*;
import java.awt.*;

/**
 * The Header class extends {@link Label} to create a custom label styled as a header.
 * It provides constructors to set the text, alignment, and font styling for a header.
 */
public class Header extends Label {
    public Header(String text) {
        this(text, SwingConstants.LEFT);
    }

    public Header(String text, int horizontalAlignment) {
        this.setText(text);
        this.setHorizontalAlignment(horizontalAlignment);
        this.setFont(new Font("Arial", Font.BOLD, 24));
    }
}

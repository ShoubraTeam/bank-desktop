package com.bank.ui;

import javax.swing.*;
import java.awt.*;

/**
 * <p>
 * A centralized custom Label class that extends {@link JLabel} to provide
 * predefined styles such as font, size, and alignment for labels.
 * </p>
 *
 * <p>
 * <strong>NOTE:</strong> Should be used in the whole application.
 * </p>
 */
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

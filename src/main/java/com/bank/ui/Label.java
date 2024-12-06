package com.bank.ui;

import javax.swing.*;
import java.awt.*;

/**
 * <p>
 * A centralized custom Label class that extends {@link JLabel}
 * </p>
 *
 * <p>
 * <strong>NOTE:</strong> Should be used in the whole application for any text or label related.
 * </p>
 */
public class Label extends JLabel {
    public Label(String text) {
        this.setText(text);
        this.setFont(new Font("Arial", Font.PLAIN, 16));
    }
}

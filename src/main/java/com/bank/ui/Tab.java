package com.bank.ui;

import com.bank.config.Colors;
import com.bank.config.TabKey;

import javax.swing.*;
import java.awt.*;

public class Tab extends JButton {
    private TabKey key;
    private JPanel view;
    private boolean active;

    public Tab(String text, TabKey key, JPanel view) {
        this.key = key;
        this.view = view;
        this.active = false;

        this.setText(text);
        this.setModel(new FixedStateButtonModel());
        this.setFocusPainted(false);
        this.setForeground(Color.BLACK);
        this.setBackground(Colors.SECONDRY_BACKGROUND_COLOR);
        this.setHorizontalAlignment(SwingConstants.LEFT);
        this.setFont(new Font("Arial", Font.PLAIN, 16));
        this.setBorderPainted(false);
    }

    public TabKey getKey() {
        return this.key;
    }

    public JPanel getView() {
        return this.view;
    }

    public void setActive(boolean active) {
        this.active = active;
        if (this.active) {
            this.setBackground(Colors.BACKGROUND_COLOR);
        } else {
            this.setBackground(Colors.SECONDRY_BACKGROUND_COLOR);
        }
    }

    private static class FixedStateButtonModel extends DefaultButtonModel {
        @Override
        public boolean isPressed() {
            return false;
        }

        @Override
        public void setRollover(boolean b) {
            // NOOP
        }
    }
}

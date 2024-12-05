package com.bank.views;

import com.bank.config.Colors;
import com.bank.ui.Label;
import com.bank.ui.Tab;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class DashboardPanel extends JPanel {
    private final Tab[] tabs;

    public DashboardPanel(Tab[] tabs) {
        this.tabs = tabs;

        this.setBorder(new MatteBorder(0, 0, 0, 1, Colors.BORDER_COLOR));
        this.setLayout(new GridLayout(12, 1));
        this.setPreferredSize(new Dimension(250, 0));
        this.setBackground(Colors.SECONDRY_BACKGROUND_COLOR);

        this.add(new Label("BANK", SwingConstants.CENTER));

        this.viewTabs();
    }

    private void viewTabs() {
        for (Tab tab : tabs) {
            this.add(tab);
        }
    }
}

package com.bank.views;

import com.bank.config.Colors;
import com.bank.config.Constants;
import com.bank.ui.TabPanel;

import javax.swing.*;

public class Application extends JFrame {
    public Application() {
        this.setSize(1280, 768);
        this.setResizable(false);
        this.setBackground(Colors.BACKGROUND_COLOR);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("BANK");

        this.add(new TabPanel(Constants.tabs));

        this.setVisible(true);
    }
}

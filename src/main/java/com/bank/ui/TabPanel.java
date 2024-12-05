package com.bank.ui;

import com.bank.views.ContentPanel;
import com.bank.views.DashboardPanel;

import javax.swing.*;
import java.awt.*;

public class TabPanel extends JPanel {
    private final Tab[] tabs;
    private final ContentPanel contentPanel;
    private final DashboardPanel dashboardPanel;

    public TabPanel(Tab[] tabs) {
        this.tabs = tabs;

        this.setLayout(new BorderLayout());
        contentPanel = new ContentPanel();
        dashboardPanel = new DashboardPanel(tabs);

        this.add(dashboardPanel, BorderLayout.WEST);
        this.add(contentPanel);

        this.initializeTabs();
    }

    private void initializeTabs() {
        for (Tab tab : this.tabs) {
            contentPanel.add(tab.getView(), String.valueOf(tab.getKey()));
            tab.addActionListener((_) -> setActiveTab(tab));
        }
        this.setActiveTab(tabs[0]);
    }

    private void setActiveTab(Tab tab) {
        CardLayout layout = (CardLayout) contentPanel.getLayout();
        layout.show(contentPanel, String.valueOf(tab.getKey()));
        for (Tab t : this.tabs) {
            t.setActive(false);
        }
        tab.setActive(true);
    }
}

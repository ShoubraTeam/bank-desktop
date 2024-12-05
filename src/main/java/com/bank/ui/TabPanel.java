package com.bank.ui;

import com.bank.views.ContentPanel;
import com.bank.views.DashboardPanel;

import javax.swing.*;
import java.awt.*;

/**
 * A panel that manages a tabbed navigation system for the application.
 * <p>
 * This class extends {@link JPanel} and organizes tabs along with their
 * associated views. It uses a {@link ContentPanel} to dynamically display
 * the content of the active tab and a {@link DashboardPanel} to display
 * the tab controls on the left side of the panel.
 * </p>
 */
public class TabPanel extends JPanel {
    /** The array of tabs managed by this panel. */
    private final Tab[] tabs;

    /** The panel used to display the content of the active tab. */
    private final ContentPanel contentPanel;

    /** The panel used to display the tab controls. */
    private final DashboardPanel dashboardPanel;

    /**
     * Constructs a new {@code TabPanel} with the specified tabs.
     * <p>
     * Initializes the layout and adds the {@link DashboardPanel} on the left
     * and the {@link ContentPanel} in the center. It also sets up the tabs
     * and their associated views for dynamic content switching.
     * </p>
     *
     * @param tabs an array of {@link Tab} objects representing the navigation tabs
     */
    public TabPanel(Tab[] tabs) {
        this.tabs = tabs;

        this.setLayout(new BorderLayout());
        contentPanel = new ContentPanel();
        dashboardPanel = new DashboardPanel(tabs);

        this.add(dashboardPanel, BorderLayout.WEST);
        this.add(contentPanel);

        this.initializeTabs();
    }

    /**
     * Initializes the tabs by adding their views to the {@link ContentPanel}
     * and setting up action listeners for dynamic tab switching.
     */
    private void initializeTabs() {
        for (Tab tab : this.tabs) {
            contentPanel.add(tab.getView(), String.valueOf(tab.getKey()));
            tab.addActionListener((_) -> setActiveTab(tab));
        }
        this.setActiveTab(tabs[0]);
    }

    /**
     * Sets the specified tab as the active tab.
     * <p>
     * This method updates the {@link ContentPanel} to display the view associated
     * with the active tab and visually highlights the active tab in the {@link DashboardPanel}.
     * </p>
     *
     * @param tab the {@link Tab} to be set as active
     */
    private void setActiveTab(Tab tab) {
        CardLayout layout = (CardLayout) contentPanel.getLayout();
        layout.show(contentPanel, String.valueOf(tab.getKey()));
        for (Tab t : this.tabs) {
            t.setActive(false);
        }
        tab.setActive(true);
    }
}

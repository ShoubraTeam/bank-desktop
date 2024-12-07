package com.bank.views.tabs;

import com.bank.views.ContentPanel;

import javax.swing.*;
import java.awt.*;

/**
 * A panel that manages a tabbed navigation system for the application.
 * <p>
 * This class extends {@link JPanel} and organizes tabs along with their
 * associated views. It uses a {@link ContentPanel} to dynamically display
 * the content of the active tab and a {@link TabList} to display
 * the tab controls on the left side of the panel.
 * </p>
 */
public class TabPanel extends JPanel {
    /** The array of tabs managed by this panel. */
    private final Tab[] tabs;

    /** The panel used to display the content of the active tab. */
    private final ContentPanel contentPanel;

    /** The panel used to display the tab controls. */
    private final TabList tabList;

    /**
     * Constructs a new {@code TabPanel} with the specified tabs.
     * <p>
     * Initializes the layout and adds the {@link TabList} on the left
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
        tabList = new TabList(tabs);

        this.add(tabList, BorderLayout.WEST);
        this.add(contentPanel, BorderLayout.CENTER);

        this.initializeTabs();
        this.setActiveTab(tabs[0]);
    }

    /**
     * Initializes the tabs by adding their views to the {@link ContentPanel}
     * and setting up action listeners for dynamic tab switching.
     */
    private void initializeTabs() {
        for (Tab tab : this.tabs) {
            contentPanel.add(tab.getView(), tab.getKey());
            tab.addActionListener(e -> setActiveTab(tab));
        }
    }

    /**
     * Sets the specified tab as the active tab.
     * <p>
     * This method updates the {@link ContentPanel} to display the view associated
     * with the active tab and visually highlights the active tab in the
     * {@link TabList}.
     * </p>
     *
     * @param tab the {@link Tab} to be set as active
     */
    private void setActiveTab(Tab tab) {
        CardLayout layout = (CardLayout) contentPanel.getLayout();
        layout.show(contentPanel, tab.getKey());
        for (Tab t : this.tabs) {
            t.setActive(false);
        }
        tab.setActive(true);
    }
}

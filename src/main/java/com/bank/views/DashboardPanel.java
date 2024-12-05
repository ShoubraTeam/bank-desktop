package com.bank.views;

import com.bank.config.Colors;
import com.bank.ui.Label;
import com.bank.ui.Tab;

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

/**
 * A panel that serves as the dashboard for the application's navigation system.
 * <p>
 * This class extends {@link JPanel} and displays a list of tabs, allowing users
 * to navigate between different sections of the application. It includes a title
 * label and applies a consistent layout and styling.
 * </p>
 */
public class DashboardPanel extends JPanel {
    /** The array of tabs displayed in the dashboard. */
    private final Tab[] tabs;

    /**
     * Constructs a new {@code DashboardPanel} with the specified tabs.
     * <p>
     * Configures the panel with a vertical grid layout to arrange the tabs,
     * a border on the right side, and a background color. The panel also includes
     * a title label at the top.
     * </p>
     *
     * @param tabs an array of {@link Tab} objects to be displayed in the dashboard
     */
    public DashboardPanel(Tab[] tabs) {
        this.tabs = tabs;

        this.setBorder(new MatteBorder(0, 0, 0, 1, Colors.BORDER_COLOR));
        this.setLayout(new GridLayout(12, 1));
        this.setPreferredSize(new Dimension(250, 0));
        this.setBackground(Colors.SECONDARY_BACKGROUND_COLOR);

        this.add(new Label("BANK", SwingConstants.CENTER));

        this.viewTabs();
    }

    /**
     * Adds all tabs to the panel.
     * <p>
     * Iterates through the provided tabs and adds each one to the panel's layout.
     * </p>
     */
    private void viewTabs() {
        for (Tab tab : tabs) {
            this.add(tab);
        }
    }
}

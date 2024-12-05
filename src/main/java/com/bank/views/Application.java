package com.bank.views;

import com.bank.config.Colors;
import com.bank.config.Constants;
import com.bank.ui.TabPanel;

import javax.swing.*;

/**
 * The main application window for the Bank System.
 * <p>
 * This class extends {@link JFrame} and serves as the primary container
 * for the graphical user interface (GUI) of the application. It sets up
 * the main window with a fixed size, title, background color, and a tabbed
 * panel
 * for navigating between different application features.
 * </p>
 */
public class Application extends JFrame {
    /**
     * Constructs a new {@code Application} window.
     * <p>
     * Initializes the main window with:
     * <ul>
     * <li>Fixed dimensions of 1280x768 pixels</li>
     * <li>A non-resizable frame</li>
     * <li>A predefined background color from {@link Colors}</li>
     * <li>Exit-on-close behavior</li>
     * <li>A title of "BANK"</li>
     * <li>A {@link TabPanel} for displaying tabs, initialized with
     * constants from {@link Constants#tabs}</li>
     * </ul>
     * Finally, the window is set to be visible.
     * </p>
     */

    public Application() {
        this.setSize(1280, 768);
        this.setResizable(false);
        this.setBackground(Colors.BACKGROUND_COLOR);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("BANK");
        this.setLocationRelativeTo(null); // Appear centered of the screen

        this.add(new TabPanel(Constants.tabs));

        this.setVisible(true);
    }
}

package com.bank.ui;

import com.bank.config.Colors;
import com.bank.config.TabKey;

import javax.swing.*;
import java.awt.*;

/**
 * A custom button representing a tab in the application's navigation system.
 * <p>
 * Each tab has an associated unique key, a content view (as a {@link JPanel}),
 * and an active state indicating whether the tab is currently selected. The
 * appearance of the tab is styled for consistency with the application's design.
 * </p>
 */
public class Tab extends JButton {
    /** The unique key identifying this tab. */
    private final TabKey key;

    /** The view (panel) displayed when this tab is active. */
    private final JPanel view;

    /** Indicates whether this tab is currently active. */
    private boolean active;

    /**
     * Constructs a new {@code Tab} with the specified text, key, and associated view.
     * <p>
     * Initializes the tab with custom styling, including fonts, colors, alignment,
     * and focus behavior. The tab is inactive by default.
     * </p>
     *
     * @param text the text to be displayed on the tab
     * @param key  the unique key identifying this tab
     * @param view the {@link JPanel} associated with this tab
     */
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

    /**
     * Gets the unique key identifying this tab.
     *
     * @return the {@link TabKey} associated with this tab
     */
    public TabKey getKey() {
        return this.key;
    }

    /**
     * Gets the view associated with this tab.
     *
     * @return the {@link JPanel} displayed when this tab is active
     */
    public JPanel getView() {
        return this.view;
    }

    /**
     * Sets the active state of this tab and updates its appearance accordingly.
     *
     * @param active {@code true} to set the tab as active; {@code false} otherwise
     */
    public void setActive(boolean active) {
        this.active = active;
        if (this.active) {
            this.setBackground(Colors.BACKGROUND_COLOR);
        } else {
            this.setBackground(Colors.SECONDRY_BACKGROUND_COLOR);
        }
    }

    /**
     * A custom button model that disables press and rollover states for tabs.
     * <p>
     * This ensures that tabs have a consistent appearance and do not respond
     * to typical button press or hover effects.
     * </p>
     */
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

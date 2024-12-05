package com.bank.views;

import javax.swing.*;
import java.awt.*;

/**
 * A panel that serves as a container for displaying different content views.
 * <p>
 * This class extends {@link JPanel} and uses a {@link CardLayout} to manage
 * multiple components, allowing for easy switching between views. It is
 * designed to be used in applications where dynamic content needs to be displayed
 * one view at a time.
 * </p>
 */
public class ContentPanel extends JPanel {
    public ContentPanel() {
        this.setLayout(new CardLayout());
    }
}

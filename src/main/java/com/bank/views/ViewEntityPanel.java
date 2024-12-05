package com.bank.views;

import com.bank.ui.Label;

import javax.swing.*;

/**
 * A panel that represents the "View Entity" page of the application.
 * <p>
 * This class extends {@link JPanel} and provides the foundation
 * for displaying entities in the system. Currently, it includes
 * a title label displaying "View Entity".
 * </p>
 */
public class ViewEntityPanel extends JPanel {
    public ViewEntityPanel(){
        this.add(new Label("View Entity"));
    }
}

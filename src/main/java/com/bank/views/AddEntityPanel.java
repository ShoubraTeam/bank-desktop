package com.bank.views;

import com.bank.ui.Header;

import javax.swing.*;

/**
 * A panel that represents the "Add Entity" page of the application.
 * <p>
 * This class extends {@link JPanel} and provides the foundation
 * for adding entities in the system. Currently, it includes
 * a title label displaying "Add Entity".
 * </p>
 */
public class AddEntityPanel extends JPanel {
    public AddEntityPanel(){
        this.add(new Header("Add Entity"));
    }
}

package com.bank.views;

import com.bank.config.Constants;
import com.bank.ui.Header;
import com.bank.views.dynamicform.DynamicForm;
import com.bank.views.forms.RowPanelOneItem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


/**
 * A panel that represents the "Add Entity" page of the application.
 * <p>
 * This class extends {@link JPanel} and provides the foundation
 * for adding entities in the system. Currently, it includes
 * a title label displaying "Add Entity".
 * </p>
 */
public class AddEntityPanel extends JPanel {
    public AddEntityPanel() {
        DynamicForm form = new DynamicForm("Entity Type", Constants.ADD_ENTITY_OPTIONS);

        this.setBorder(new EmptyBorder(24, 24, 24, 24)); // add spacing
        this.setLayout(new BorderLayout(21, 12));
        this.add(new RowPanelOneItem<Header>(new Header("Add Entity")), BorderLayout.NORTH);
        this.add(form, BorderLayout.CENTER);
    }

}

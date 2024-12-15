package com.bank.views;

import com.bank.config.Colors;
import com.bank.config.Constants;
import com.bank.database.DatabaseProvider;
import com.bank.ui.Header;
import com.bank.views.dynamicform.DynamicForm;
import com.bank.views.forms.RowPanelOneItem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * A panel that represents the "View Entity" page of the application.
 * <p>
 * This class extends {@link JPanel} and provides the foundation
 * for displaying entities in the system. Currently, it includes
 * a title label displaying "View Entity".
 * </p>
 */
public class QueriesEntityPanel extends JPanel {
    public QueriesEntityPanel() {
        DynamicForm form = new DynamicForm("Query", Constants.QUERIES_OPTIONS);

        this.setBorder(new EmptyBorder(24, 24, 24, 24)); // add spacing
        this.setLayout(new BorderLayout(21, 12));
        this.add(new RowPanelOneItem<Header>(new Header("Queries")), BorderLayout.NORTH);
        this.add(form, BorderLayout.CENTER);
    }
}

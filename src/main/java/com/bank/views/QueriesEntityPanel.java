package com.bank.views;

import com.bank.config.Constants;
import com.bank.ui.Header;
import com.bank.views.dynamicform.DynamicForm;
import com.bank.views.forms.RowPanelOneItem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class QueriesEntityPanel extends JPanel {
    public QueriesEntityPanel() {
        DynamicForm form = new DynamicForm("Entity Type", Constants.QUERIES_OPTIONS);

        this.setBorder(new EmptyBorder(24, 24, 24, 24)); // add spacing
        this.setLayout(new BorderLayout(21, 12));
        this.add(new RowPanelOneItem<Header>(new Header("Queries")), BorderLayout.NORTH);
        this.add(form, BorderLayout.CENTER);
    }
}
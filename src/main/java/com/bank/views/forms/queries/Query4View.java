package com.bank.views.forms.queries;

import com.bank.config.Colors;
import com.bank.config.EntityConstants;
import com.bank.controllers.ATMController;
import com.bank.controllers.BankAccountController;
import com.bank.controllers.CustomerController;
import com.bank.ui.Button;
import com.bank.utils.Helpers;
import com.bank.views.QueriesEntityPanel;
import com.bank.views.forms.Form;
import com.bank.views.forms.RowPanelOneItem;
import com.bank.views.forms.RowPanelTwoItems;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import com.bank.utils.Dialog;


public class Query4View extends Form {
    private JPanel tablePanel;
    private RowPanelTwoItems newRow;

    public Query4View() {
        Button submitBtn = new Button("Run Query");
        JPanel formPanel = new JPanel();
        tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Padding for table
        tablePanel.setVisible(false); // Hide the table panel initially

        formPanel.setLayout(new GridLayout(10, 1, 12, 12));
        formPanel.setBorder(new EmptyBorder(18, 18, 18, 18));

        this.setLayout(new BorderLayout(12, 12));

        // إضافة المكونات داخل formPanel
//        for (RowPanelTwoItems row : EntityConstants.QUERY_ONE) {
//            newRow = row;
//            formPanel.add(newRow);
//        }

        JScrollPane formScrollPane = new JScrollPane(formPanel);
        formScrollPane.setPreferredSize(new Dimension(500, 600));
        formScrollPane.setBorder(new MatteBorder(3, 3, 3, 3, Colors.SECONDARY_COLOR));
        this.add(formScrollPane, BorderLayout.CENTER);

        // إضافة زر التقديم
        submitBtn.addActionListener(submit());
        this.add(new RowPanelOneItem<>(submitBtn), BorderLayout.SOUTH);
    }

    public ActionListener submit() {
        return (e) -> {
            //ArrayList<String> values = Helpers.getValuesFromInputs(EntityConstants.QUERY_TWO);
            tablePanel.removeAll(); // إزالة أي مكونات موجودة في tablePanel
            tablePanel.revalidate(); // تحديث تخطيط الـ tablePanel
            tablePanel.repaint();    // إعادة رسم الـ tablePanel

            BankAccountController.QueryFour();

            // إنشاء الجدول بالبيانات
            JTable table = new JTable(new DefaultTableModel(BankAccountController.data, BankAccountController.columns_name));
            JScrollPane scrollPane = new JScrollPane(table); // إضافة التمرير للجدول
            tablePanel.add(scrollPane, BorderLayout.CENTER);
            System.out.println("Data: " + Arrays.toString(BankAccountController.data));
            System.out.println("Columns: " + Arrays.toString(BankAccountController.columns_name));
            // عرض الجدول بشكل صحيح
            tablePanel.setVisible(true);
            this.add(tablePanel);
            // إعادة تحديث الـ tablePanel و إعادة رسمه
            tablePanel.revalidate();
            tablePanel.repaint();
        };
    }
}

package com.bank.views.dynamicform;

import javax.swing.*;
import java.awt.*;

public class DynamicForm extends JPanel {
    DynamicFormDropdown dropdown;
    DynamicFormView view;

    public DynamicForm(String label, DynamicFormOption[] options) {
        this.setLayout(new BorderLayout(0, 24));
        this.dropdown = new DynamicFormDropdown(label, options);
        this.view = new DynamicFormView();

        this.add(dropdown.getRow(), BorderLayout.NORTH);
        this.add(view, BorderLayout.CENTER);

        for (DynamicFormOption o : options) {
            this.view.add(o.getView(), o.getName());
        }

        this.dropdown.getComboBox().addActionListener((e) -> {
            setActiveView(this.dropdown.getComboBox().getSelectedItem().toString());
        });
    }

    public void setActiveView(String name) {
        CardLayout layout = (CardLayout) view.getLayout();
        layout.show(view, name);
        view.revalidate();
        view.repaint();
    }
}

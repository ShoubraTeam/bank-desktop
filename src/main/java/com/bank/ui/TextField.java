package com.bank.ui;

import javax.swing.*;

public class TextField extends JTextField {
    public TextField(String hiddenText)
    {
        this.setSize(695,64);
        this.setText(hiddenText);
        this.setVisible(true);
    }


}

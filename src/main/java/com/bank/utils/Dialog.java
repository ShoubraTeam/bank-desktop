package com.bank.utils;

import javax.swing.*;

public class Dialog {
    public static void showSuccessfulMessage(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void showSuccessfulMessage(String msg) {
        showSuccessfulMessage(msg, "Success");
    }

    public static void showErrorMessage(String msg, String title) {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE);
    }

    public static void showErrorMessage(String msg) {
        showErrorMessage(msg, "Error");
    }
}

package com.bank;

import com.bank.views.Application;

public class Main {
    public static void main(String[] args) {
        // Ensure GUI-related code runs on Event Dispatch Thread (EDT) which is the
        // thread responsible for managing updates to the graphical user interface
        // in Swing applications.
        javax.swing.SwingUtilities.invokeLater(Application::new);
    }
}

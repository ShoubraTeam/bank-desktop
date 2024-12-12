package com.bank;

import com.bank.config.Env;
import com.bank.views.Application;

/**
 * The entry point for the Bank System application.
 * <p>
 * This class initializes and launches the application by ensuring
 * that all GUI-related code runs on the Event Dispatch Thread (EDT),
 * which is responsible for managing updates to the graphical user interface
 * in Swing applications.
 * </p>
 */
public class Main {
    /**
     * The main method that serves as the starting point of the application.
     * <p>
     * This method uses {@link javax.swing.SwingUtilities#invokeLater} to ensure
     * that the {@link com.bank.views.Application} GUI is created and executed
     * on the EDT, maintaining thread safety for all Swing components.
     * </p>
     *
     * @param args command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        Env.load();
        javax.swing.SwingUtilities.invokeLater(Application::new);
    }
}

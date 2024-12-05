package com.bank.config;

import com.bank.views.tabs.Tab;
import com.bank.views.AddEntityPanel;
import com.bank.views.ViewEntityPanel;

/**
 * A utility class that defines constant values used throughout the application.
 * <p>
 * This class contains static constants such as predefined tabs.
 * </p>
 */
public class Constants {
    /**
     * An array of {@link Tab} objects representing the available tabs in the
     * application's navigation panel. Each tab is associated with a label,
     * a unique {@link TabKey}, and a corresponding <code>JPanel</code> that
     * represents the content for that tab.
     */
    public static final Tab[] tabs = {
            new Tab("View Entity", "ViewEntity", new ViewEntityPanel()),
            new Tab("Add Entity", "AddEntity", new AddEntityPanel()),
    };
}

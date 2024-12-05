package com.bank.config;

import java.awt.*;

/**
 * A utility class containing color constants used for the application's theme.
 * <p>
 * This class defines a set of static {@link Color} objects to ensure consistent
 * styling across the user interface.
 * </p>
 */
public class Colors {
    public final static Color TEXT_COLOR = Color.black;
    public final static Color PRIMARY_COLOR = Color.black;
    public final static Color SECONDARY_BACKGROUND_COLOR = Color.white;
    public final static Color BACKGROUND_COLOR = new Color(0xEEEEEEEE);
    public final static Color BORDER_COLOR = new Color(0xC1BDBD);

    /**
     * Private constructor to prevent instantiation.
     * <p>
     * This class is designed to be a utility class, and therefore,
     * it should not be instantiated.
     * </p>
     */
    private Colors() {
        throw new UnsupportedOperationException("Colors is a utility class and cannot be instantiated");
    }
}

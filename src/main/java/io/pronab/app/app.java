package io.pronab.app;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class app {
    private static final String BUNDLE_NAME = "app";

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private app() {
    }

    public static String getString(String key) {
        try {
            return RESOURCE_BUNDLE.getString(key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }
}

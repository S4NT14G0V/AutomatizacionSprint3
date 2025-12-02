package org.calidadsoftware.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesReader {

    private static final Properties PROPS = new Properties();
    private static boolean loaded = false;

    private PropertiesReader() { }

    private static synchronized void load() {
        if (loaded) return;
        try (InputStream input = PropertiesReader.class.getClassLoader().getResourceAsStream("serenity.properties")) {
            if (input != null) {
                PROPS.load(input);
            }
        } catch (IOException ignored) {
            // if properties cannot be loaded, PROPS stays empty and defaults will be used
        }
        loaded = true;
    }

    // Mantener el método original sin parámetro por compatibilidad
    public static String getProperty(String key) {
        load();
        return PROPS.getProperty(key, "http://localhost:8080");
    }

    // Nueva sobrecarga que acepta valor por defecto
    public static String getProperty(String key, String defaultValue) {
        load();
        return PROPS.getProperty(key, defaultValue);
    }
}

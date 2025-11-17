package com.tp3qualityrefactoring.app.config;

import java.util.Properties;
import java.io.InputStream;

public class ConfigLoader {
    private Properties properties = new Properties();

    public ConfigLoader() {
        try (InputStream input = getClass().getResourceAsStream("/com/tp3qualityrefactoring/config.properties")) {
            if (input == null) {
                throw new RuntimeException("config.properties introuvable dans le classpath !");
            }
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}

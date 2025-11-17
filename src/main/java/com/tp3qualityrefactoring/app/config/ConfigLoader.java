package com.tp3qualityrefactoring.app.config;

import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;

public class ConfigLoader {
    private final Properties properties = new Properties();

    public ConfigLoader() throws IOException {
        try (InputStream input = getClass().getResourceAsStream("/com/tp3qualityrefactoring/config.properties")) {
            if (input == null) {
                throw new IllegalStateException("config.properties introuvable dans le classpath !");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new IOException("Erreur lors du chargement de config.properties: "+  e.getMessage());
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}

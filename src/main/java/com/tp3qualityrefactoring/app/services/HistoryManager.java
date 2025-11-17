package com.tp3qualityrefactoring.app.services;

import com.tp3qualityrefactoring.app.config.ConfigLoader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class HistoryManager {

    private final String historyFilePath;

    public HistoryManager() {
        ConfigLoader configLoader = new ConfigLoader();
        this.historyFilePath = configLoader.getProperty("history.file");
    }
    public void saveCalculation(String fullMessage) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(historyFilePath, true))) {
            writer.write("[" + timestamp + "]\n" + fullMessage + "\n---------------------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.tp3qualityrefactoring.app.services;

import com.tp3qualityrefactoring.app.config.ConfigLoader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class HistoryManager {

    private final String historyFilePath;

    public HistoryManager() throws IOException{
        try {
            ConfigLoader configLoader = new ConfigLoader();
            this.historyFilePath = configLoader.getProperty("history.file");
        } catch (IOException e) {
            throw new IOException("Erreur: " + e.getMessage());
        }
    }
    public void saveCalculation(String fullMessage) throws IOException{
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(historyFilePath, true))) {
            writer.write("[" + timestamp + "]\n" + fullMessage + "\n---------------------------------\n");
        } catch (IOException e) {
            throw new IOException("Erreur: " + e.getMessage());
        }
    }

    public String readHistory() throws  IOException{
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(historyFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            return builder.toString();
        } catch (IOException e){
            throw new IOException("Erreur: " + e.getMessage());
        }
    }

}

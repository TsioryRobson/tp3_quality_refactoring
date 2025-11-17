package com.tp3qualityrefactoring.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.Objects;

public class MainApp extends Application {
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tp3qualityrefactoring/main-view.fxml"));
        Scene scene = new Scene(loader.load(), 600, 600);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/tp3qualityrefactoring/style.css")).toExternalForm());
        stage.setTitle("Calculatrice Second Degré");
        stage.setScene(scene);
        stage.show();
    }
}

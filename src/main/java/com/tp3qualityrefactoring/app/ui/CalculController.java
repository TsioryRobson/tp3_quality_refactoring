package com.tp3qualityrefactoring.app.ui;

import com.tp3qualityrefactoring.app.services.HistoryManager;
import com.tp3qualityrefactoring.app.services.Validator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import com.tp3qualityrefactoring.app.services.Calculservice;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class CalculController {
    @FXML private TextField inputA;
    @FXML private TextField inputB;
    @FXML private TextField inputC;
    @FXML private Label resultLabel;

    private final Calculservice calculService;
    private final HistoryManager historyManager;

    public CalculController() throws IOException {
        try {
            calculService = new Calculservice();
            historyManager = new HistoryManager();
        }catch (IOException e){
            throw new IOException("Erreur: " + e.getMessage());
        }
    }

    @FXML
    public void onCalculate() {
        try {
            double a = Validator.verifyNumeric(inputA.getText());
            double b = Validator.verifyNumeric(inputB.getText());
            double c = Validator.verifyNumeric(inputC.getText());
            String resultMessage = calculService.solveQuadraticVerbose(a, b, c);
            resultLabel.setText(resultMessage);
            historyManager.saveCalculation(resultMessage);
        } catch (Exception e) {
            resultLabel.setText(e.getMessage());
        }
    }

    public void onShowHistory() throws Exception {
        try {
            String historyContent = historyManager.readHistory();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/tp3qualityrefactoring/history-view.fxml"));
            Parent root = loader.load();

            HistoryController controller = loader.getController();
            controller.setHistoryText(historyContent);

            Stage stage = new Stage();
            stage.setTitle("Historique");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            throw new IOException("Erreur lors de la lecture de l’historique", e);
        }
    }
}

package com.tp3qualityrefactoring.app.ui;

import com.tp3qualityrefactoring.app.services.HistoryManager;
import com.tp3qualityrefactoring.app.services.Validator;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import com.tp3qualityrefactoring.app.services.Calculservice;

import java.util.Arrays;

public class CalculController {
    @FXML private TextField inputA;
    @FXML private TextField inputB;
    @FXML private TextField inputC;
    @FXML private Label resultLabel;

    private Calculservice calculService = new Calculservice();
    private Validator validator = new Validator();
    private HistoryManager historyManager = new HistoryManager();

    @FXML
    public void onCalculate() {
        if (validator.isNumeric(inputA.getText()) &&
                validator.isNumeric(inputB.getText()) &&
                validator.isNumeric(inputC.getText())) {
            try {
                double a = Double.parseDouble(inputA.getText());
                double b = Double.parseDouble(inputB.getText());
                double c = Double.parseDouble(inputC.getText());
                String resultMessage = calculService.solveQuadraticVerbose(a, b, c);
                resultLabel.setText(resultMessage);
                historyManager.saveCalculation(resultMessage);
            } catch (Exception e) {
                resultLabel.setText(e.getMessage());
            }
        } else {
            resultLabel.setText("Entrée invalide !");
        }
    }
}

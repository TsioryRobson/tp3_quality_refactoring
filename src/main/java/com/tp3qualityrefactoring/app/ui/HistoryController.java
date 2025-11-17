package com.tp3qualityrefactoring.app.ui;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

public class HistoryController {
    @FXML
    private TextArea historyArea;

    public void setHistoryText(String text) {
        historyArea.setText(text);
    }
}

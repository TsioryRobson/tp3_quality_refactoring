module com.tp3qualityrefactoring {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.tp3qualityrefactoring.app.ui to javafx.fxml;
    exports com.tp3qualityrefactoring.app;
}
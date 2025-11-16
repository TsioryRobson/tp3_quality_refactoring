module com.tp3qualityrefactoring {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tp3qualityrefactoring to javafx.fxml;
    exports com.tp3qualityrefactoring;
}
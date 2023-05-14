module com.example.methodologia {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.example.methodologia to javafx.fxml;
    exports com.example.methodologia;
}
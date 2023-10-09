module com.example.appdictionary {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens com.example.appdictionary to javafx.fxml;
    exports com.example.appdictionary;
    exports com.example.appdictionary.Cotroller;
    opens com.example.appdictionary.Cotroller to javafx.fxml;
}
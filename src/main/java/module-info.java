module com.example.javafx7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx7 to javafx.fxml;
    exports com.example.javafx7;
}
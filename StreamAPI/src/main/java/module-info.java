module org.example.streamapi {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.streamapi to javafx.fxml;
    exports org.example.streamapi;
}
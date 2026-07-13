package org.example.streamapi;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    Service service = new Service();
    @FXML
    private TextField txtField;
    @FXML
    private Label lbl_Error;
    @FXML
    private ListView<String> listView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtField.setPromptText("ingrese unicamente strings");
    }

    public void btnHandle() {
        try {
            String txt = txtField.getText().trim();
            service.add(txt);

        } catch (Exception e) {
            lbl_Error.setText(e.getMessage());
        }
    }

    public void btnHandleResult() {
        listView.setItems(FXCollections.observableArrayList(service.show()));
    }
}

package org.example.streamapi;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    Service service = new Service();

    @FXML
    private Label amount;
    @FXML
    private TextField txt_remove;
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
            lbl_Error.setVisible(true);
            PauseTransition pause = new PauseTransition(Duration.seconds(1.3));
            pause.setOnFinished(event -> lbl_Error.setVisible(false));
            pause.play();
        }
    }

    public void btnHandleResult() {
        int value = service.amount();
        listView.setItems(FXCollections.observableArrayList(service.show()));
        amount.setText(String.valueOf(value));
    }
    public void btnHandleRemove(){
        String txt = txt_remove.getText();
        service.delete(txt);
    }
}

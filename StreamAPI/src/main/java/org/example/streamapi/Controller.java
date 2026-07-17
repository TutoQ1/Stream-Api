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
    private TextField txtField;
    @FXML
    private Label lbl_Error;
    @FXML
    private ListView<String> listView;

    private String selectedItem;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtField.setPromptText("ingrese unicamente strings");

        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                selectedItem = newVal;
                txtField.setText(newVal);
            }
        });
    }

    public void btnHandle() {
        try {
            String txt = txtField.getText().trim();
            service.validate(txt);
            service.add(txt);
            btnHandleResult();

        } catch (Exception e) {
            error(e);
        }
    }

    public void btnHandleResult() {
        int value = service.amount();
        listView.setItems(FXCollections.observableArrayList(service.show()));
        amount.setText(String.valueOf(value));
    }

    public void btnHandleRemove(){
        String txt = txtField.getText();
        service.delete(txt);
        btnHandleResult();
    }

    public void btnHandleEdit(){
        try {
            String txt = txtField.getText();
            service.edit(selectedItem, txt);
            service.validate1(txt);

            btnHandleResult();
        }catch (Exception e){
            error(e);
        }
    }
    public void error(Exception e){
        lbl_Error.setVisible(true);
        lbl_Error.setText(e.getMessage());
        lbl_Error.setVisible(true);
        PauseTransition pause = new PauseTransition(Duration.seconds(1.3));
        pause.setOnFinished(event -> lbl_Error.setVisible(false));
        pause.play();
    }
}

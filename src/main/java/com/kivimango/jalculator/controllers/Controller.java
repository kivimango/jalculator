package com.kivimango.jalculator.controllers;

import com.kivimango.jalculator.model.CalculationModel;
import com.kivimango.jalculator.model.JalculatorModelImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import java.math.BigDecimal;

public class Controller {

    private CalculationModel model;

    @FXML public GridPane bp;
    @FXML public TextField input;
    @FXML public Label statusLabel;

    public Controller() {
         model = new JalculatorModelImpl();
    }

    @FXML
    public void initialize() {
        EventHandler<KeyEvent> handler = new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                KeyCode key = event.getCode();
                if((key.isDigitKey()) || (key == KeyCode.ADD) || (key == KeyCode.SUBTRACT) || (key == KeyCode.MULTIPLY) || (key == KeyCode.DIVIDE)) {
                    input.setText(input.getText() + event.getText());
                } else if(key == KeyCode.ENTER) {
                    BigDecimal result = model.calculate(input.getText());
                    input.setText(String.valueOf(result));
                } else if(key == KeyCode.BACK_SPACE) {
                    removeCharacterFromTextField();
                } else if(key == KeyCode.C) {
                   input.setText("0");
                }
                //System.out.println(key);
            }
        };
        bp.addEventHandler(KeyEvent.KEY_PRESSED, handler);
        System.out.println("event handler added");
    }

    @FXML
    public void handleClick(ActionEvent ae) {
        Button source = (Button) ae.getSource();
        if(source.getText().equals("C")) {
            input.setText("0");
        } else if(source.getText().equals("=")) {
            try {
                BigDecimal result = model.calculate(input.getText());
                input.setText(String.valueOf(result));
            } catch (NumberFormatException nf) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(nf.getMessage());
                alert.setContentText("Invalid input !");
                alert.showAndWait();
            }
            catch (ArithmeticException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(e.getLocalizedMessage());
                alert.showAndWait();
                }
            } else {
                if(input.getText().equals("0")) {
                    input.setText(source.getText());
                } else {
                    input.setText(input.getText() + source.getText());
                }
            }
    }

    private void removeCharacterFromTextField() {
        if(!input.getText().isEmpty()) {
            String value = input.getText();
            // do not delete the last remaining character
            if(value.length() > 1) {
                value = value.substring(0, value.length()-1);
                input.setText(value);
            }
        }
    }
}

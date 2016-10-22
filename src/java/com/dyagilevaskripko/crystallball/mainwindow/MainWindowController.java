package com.dyagilevaskripko.crystallball.mainwindow;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainWindowController {
    private MainWindowView mainWindowView;
    private Button checkButton;
    private TextField minTextField;
    private TextField maxTextField;
    private Label errorLabel;

    public MainWindowController(MainWindowView mainWindowView) {
        this.mainWindowView = mainWindowView;
        this.checkButton = mainWindowView.getButtonCheck();
        this.minTextField = mainWindowView.getMinTextField();
        this.maxTextField = mainWindowView.getMaxTextField();
        this.errorLabel = mainWindowView.getErrorLabel();

        handleCheckButton();
    }

    private void handleCheckButton() {
        checkButton.setOnAction((ActionEvent event) -> {
            System.out.println(minTextField.getText());
            System.out.println(maxTextField.getText());

            if(checkIfValueOK(minTextField,maxTextField))
                errorLabel.setVisible(false);
            else
                errorLabel.setVisible(true);

        });
    }

    public boolean checkIfValueOK(TextField minTextField,TextField maxTextField)
    {
        if (minTextField.getText().matches("[0-9]+") && maxTextField.getText().matches("[0-9]+" ))
        {
            return true;
        }
        else
        {
            return false;
        }
//        return minTextField.getText().matches("[0-9]+") && maxTextField.getText().matches("[0-9]+");
    }
}

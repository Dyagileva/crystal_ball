package com.dyagilevaskripko.crystallball.mainwindow;

import com.dyagilevaskripko.crystallball.Result;
import com.dyagilevaskripko.crystallball.db.DataBase;
import com.dyagilevaskripko.crystallball.log.LogController;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.sql.Time;
import java.time.LocalTime;

public class MainController
{
    private Button generateButton;
    private TextField minTextField;
    private TextField maxTextField;
    private Label errorLabel;
    private MainView mainView;
    private LogController logController;
    private ObservableList<Result> resultObservableList;

    public MainController(MainView mainView)
    {
        this.mainView = mainView;
        this.generateButton = mainView.getButtonGenerate();
        this.minTextField = mainView.getMinTextField();
        this.maxTextField = mainView.getMaxTextField();
        this.errorLabel = mainView.getErrorLabel();
        this.logController = new LogController();
        this.resultObservableList = logController.getResultObservableList();

        mainView.setCenter(logController.getView());

        handleCheckButton();

        resultObservableList.addAll(DataBase.read());
    }

    private void handleCheckButton()
    {
        generateButton.setOnAction((ActionEvent event) ->
                                   {
                                       if (checkIfValueOK(minTextField, maxTextField, mainView.getNameTextField()))
                                       {
                                           errorLabel.setVisible(false);

                                           int randomNumber = random(Integer.parseInt(minTextField.getText()),
                                                                     Integer.parseInt(maxTextField.getText()));
                                           mainView.setValue(randomNumber);

                                           Result result = new Result();
                                           result.setName(mainView.getNameTextField().getText());
                                           result.setTime(Time.valueOf(LocalTime.now()).toString());
                                           result.setNumber(randomNumber);

                                           DataBase.insert(result);
                                           resultObservableList.add(result);
                                       }
                                       else
                                       {
                                           errorLabel.setVisible(true);

                                           Timeline timeline = new Timeline(new KeyFrame(Duration.millis(4500),
                                                                                         ae -> errorLabel.setVisible(
                                                                                                 false)));
                                           timeline.play();
                                       }
                                   });
    }

    public boolean checkIfValueOK(TextField minTextField, TextField maxTextField, TextField nameTextField)
    {
        return minTextField.getText().matches("[0-9]+") && maxTextField.getText().matches("[0-9]+") &&
               Integer.parseInt(maxTextField.getText()) > Integer.parseInt(minTextField.getText());
    }

    public int random(int begin, int end)
    {
        return begin + (int) (Math.random() * ((end - begin) + 1));
    }
}

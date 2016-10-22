package com.dyagilevaskripko.crystallball.mainwindow;

import com.dyagilevaskripko.crystallball.circle.CircleView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * TODO add comment
 */
public class MainWindowView extends BorderPane
{
    private Label maxValueLabel;
    private Label minValueLabel;
    private Label errorLabel;
    private TextField maxTextField;
    private TextField minTextField;
    private Button buttonCheck;

    public  MainWindowView()
    {
        VBox headerVBox = createTextFieldVBox();
        headerVBox.setId("headerVBox");

        VBox circleVBox = new CircleView();
        circleVBox.setId("centerVBox");


        VBox buttonVBox = createButtonVBox();
        buttonVBox.setId("bottomVBox");

        this.setTop(headerVBox);
        this.setCenter(circleVBox);
        this.setBottom(buttonVBox);

        getStylesheets().addAll("/style/Main.css");
    }

    public VBox createTextFieldVBox()
    {
        maxValueLabel = new Label("Max value");
        minValueLabel = new Label("Min value");

        maxTextField = new TextField();
        minTextField = new TextField();

        VBox vBoxResult = new VBox();
        vBoxResult.setId("vBox");
        vBoxResult.getChildren().addAll(minValueLabel,minTextField,maxValueLabel,maxTextField);
        vBoxResult.getStylesheets().add("/resources/style/TextFields.css");

        return vBoxResult;
    }

    public VBox createButtonVBox()
    {
        buttonCheck = new Button("Check");
        errorLabel = new Label("Error");
        errorLabel.setVisible(false);

        VBox vBox = new VBox(errorLabel,buttonCheck);


        return vBox;
    }

    public Button getButtonCheck() {
        return buttonCheck;
    }

    public TextField getMaxTextField() {
        return maxTextField;
    }

    public TextField getMinTextField() {
        return minTextField;
    }

    public Label getErrorLabel() {
        return errorLabel;
    }
}

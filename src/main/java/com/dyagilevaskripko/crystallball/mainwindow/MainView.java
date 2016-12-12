package com.dyagilevaskripko.crystallball.mainwindow;

import com.dyagilevaskripko.crystallball.circle.CircleView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javax.xml.soap.Text;

public class MainView extends BorderPane
{
    private Label maxValueLabel;
    private Label minValueLabel;
    private Label errorLabel;
    private TextField maxTextField;
    private TextField minTextField;
    private TextField nameTextField;
    private Button generateButton;
    private CircleView circleView;

    public MainView()
    {
        VBox headerVBox = createTextFieldVBox();
        headerVBox.setId("headerVBox");

        circleView = new CircleView();
        circleView.setId("centerVBox");


        VBox buttonVBox = createButtonVBox();
        buttonVBox.setId("bottomVBox");
        headerVBox.getChildren().addAll(circleView,buttonVBox);

        this.setLeft(headerVBox);
//        this.setBottom(buttonVBox);

        getStylesheets().addAll("style/Main.css");
    }

    public VBox createTextFieldVBox()
    {
        maxValueLabel = new Label("Max value");
        minValueLabel = new Label("Min value");
        Label nameLabel = new Label("Name");

        maxTextField = new TextField();
        minTextField = new TextField();
        nameTextField = new TextField();

        VBox vBoxResult = new VBox();
        vBoxResult.setId("vBox");
        vBoxResult.getChildren().addAll(minValueLabel,minTextField,maxValueLabel,maxTextField,nameLabel,nameTextField);
        vBoxResult.getStylesheets().add("style/TextFields.css");

        return vBoxResult;
    }

    public VBox createButtonVBox()
    {
        generateButton = new Button("Generate");
        generateButton.getStyleClass().add("generateButton");
        errorLabel = new Label("Error");
        errorLabel.setVisible(false);
        errorLabel.getStyleClass().add("errorLabel");

        VBox vBox = new VBox(errorLabel,generateButton);
        vBox.getStyleClass().add("buttonsVBox");
        vBox.getStylesheets().addAll("style/Main.css");
        vBox.setPickOnBounds(false);

        return vBox;
    }

    public void setValue(Integer value)
    {
        circleView.setValue(value);
    }

    public int getValue()
    {
        return circleView.getValue();
    }

    public Button getButtonGenerate() {
        return generateButton;
    }

    public TextField getMaxTextField() {
        return maxTextField;
    }

    public TextField getMinTextField() {
        return minTextField;
    }

    public TextField getNameTextField()
    {
        return nameTextField;
    }

    public Label getErrorLabel() {
        return errorLabel;
    }
}

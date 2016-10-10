package com.dyagilevaskripko.crystallball.mainwindow;

import com.dyagilevaskripko.crystallball.circle.CircleView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * TODO add comment
 */
public class MainWindowView extends BorderPane
{
    private Label maxValueLabel;
    private Label minValueLabel;
    private TextField maxTextField;
    private TextField minTextField;

    public  MainWindowView()
    {
        VBox headerVBox = createTextFieldVBox();
        StackPane centerStackPane = new CircleView();

        this.setTop(headerVBox);
        this.setCenter(centerStackPane);
    }

    public VBox createTextFieldVBox()
    {
        maxValueLabel = new Label("Max value");
        minValueLabel = new Label("Min value");

        maxTextField = new TextField();
        minTextField = new TextField();

        VBox vBoxResult = new VBox();
        vBoxResult.getChildren().addAll(maxValueLabel,maxTextField,minValueLabel,minTextField);

        return vBoxResult;
    }
}

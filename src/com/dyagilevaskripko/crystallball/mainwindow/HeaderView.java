package com.dyagilevaskripko.crystallball.mainwindow;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 * TODO add comment
 */
public class HeaderView extends VBox
{
    public HeaderView()
    {
        Label minValueLabel = new Label("MIN_VALUE");
        TextField minValueTextField = new TextField();
        Label maxValueLabel = new Label("MAX_VALUE");
        TextField maxValueTextField = new TextField();

        this.getChildren().addAll(minValueLabel,minValueTextField, maxValueLabel,maxValueTextField);
    }
}

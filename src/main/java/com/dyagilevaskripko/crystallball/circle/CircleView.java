package com.dyagilevaskripko.crystallball.circle;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Created by dyagi on 10.10.2016.
 */
public class CircleView extends VBox
{
    private Label resultLabel;

    public CircleView()
    {
        this.setId("circleStackPane");

        resultLabel = new Label("...");
        resultLabel.setId("resultLabel");

        Canvas canvasBigRound = new Canvas(350, 350);
        canvasBigRound.setId("canvas");

        GraphicsContext gc = canvasBigRound.getGraphicsContext2D();
        drawShapes(gc);

        StackPane stackPane = new StackPane(canvasBigRound, resultLabel);
        stackPane.setId("stackPane");

        this.setId("mainVBox");
        this.getStylesheets().addAll("style/Circle.css");
        this.getChildren().addAll(stackPane);
    }

    private void drawShapes(GraphicsContext gc)
    {
        gc.setFill(Color.web("#2D2F2D"));
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.fillOval(25, 30, 300, 300);

        gc.setFill(Color.web("#4E524E"));
        gc.fillOval(100, 100, 145, 145);
    }

    public void setValue(Integer value)
    {
        resultLabel.setText(value.toString());
    }

    public Integer getValue()
    {
        return Integer.parseInt(resultLabel.getText());
    }
}

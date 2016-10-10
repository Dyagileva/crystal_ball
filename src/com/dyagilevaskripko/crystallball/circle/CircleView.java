package com.dyagilevaskripko.crystallball.circle;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

/**
 * Created by dyagi on 10.10.2016.
 */
public class CircleView extends StackPane {
    private Label resultLabel;

    public CircleView() {
        this.setId("circleStackPane");

        resultLabel = new Label("24");
        resultLabel.setId("resultLabel");

        Canvas canvasBigRound = new Canvas(450, 450);
        canvasBigRound.setId("canvas");

        GraphicsContext gc = canvasBigRound.getGraphicsContext2D();
        drawShapes(gc);

        this.setMinSize(300, 300);
        this.getStylesheets().addAll("/resources/style/Circle.css");
        this.getChildren().addAll(canvasBigRound,resultLabel);
    }

    private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.BLACK);
        gc.setStroke(Color.BLUE);
        gc.setLineWidth(5);
        gc.fillOval(75, 30, 300, 300);

        gc.setFill(Color.WHITE);
        gc.fillOval(155, 100, 145, 145);

    }
}

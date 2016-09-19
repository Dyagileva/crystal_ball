package com.dyagilevaskripko.crystallball.mainwindow;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * TODO add comment
 */
public class MainWindowView extends BorderPane
{
    public  MainWindowView(VBox headerView, VBox centerView, VBox bottomView)
    {
        this.setTop(headerView);
        this.setCenter(centerView);
        this.setBottom(bottomView);
    }
}

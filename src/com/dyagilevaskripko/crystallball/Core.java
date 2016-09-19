package com.dyagilevaskripko.crystallball;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * TODO add comment
 */
public class Core
{
    private WindowManager windowManager;
    private Stage primaryStage;

    public Core(Stage stage)
    {
        this.primaryStage = stage;
        windowManager = new WindowManager();
    }

    public void execute()
    {
        windowManager.showMainWindow(primaryStage);
    }
}

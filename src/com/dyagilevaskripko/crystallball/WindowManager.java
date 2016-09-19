package com.dyagilevaskripko.crystallball;

import com.dyagilevaskripko.crystallball.mainwindow.MainWindowController;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * TODO add comment
 */
public class WindowManager
{
    public void showMainWindow(Stage stage)
    {
        MainWindowController mainWindowController = new MainWindowController();
        mainWindowController.show(stage);
    }
}

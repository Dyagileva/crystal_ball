package com.dyagilevaskripko.crystallball;

import com.dyagilevaskripko.crystallball.mainwindow.MainWindowController;
import com.dyagilevaskripko.crystallball.mainwindow.MainWindowView;
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
        MainWindowView mainWindowView = new MainWindowView();
        MainWindowController mainWindowController = new MainWindowController(mainWindowView);


        Scene mainScene = new Scene(mainWindowView,450,600);

        stage.setTitle("Crystal Ball");
        stage.setScene(mainScene);
        stage.show();
    }
}

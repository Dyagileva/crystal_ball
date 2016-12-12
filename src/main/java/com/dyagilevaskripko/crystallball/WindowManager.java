package com.dyagilevaskripko.crystallball;

import com.dyagilevaskripko.crystallball.mainwindow.MainController;
import com.dyagilevaskripko.crystallball.mainwindow.MainView;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * TODO add comment
 */
public class WindowManager
{
    public void showMainWindow(Stage stage)
    {
        MainView mainWindowView = new MainView();
        MainController mainController = new MainController(mainWindowView);


        Scene mainScene = new Scene(mainWindowView,800,600);
        stage.setResizable(false);

        stage.setTitle("Crystal Ball");
        stage.setScene(mainScene);
        stage.show();
    }
}

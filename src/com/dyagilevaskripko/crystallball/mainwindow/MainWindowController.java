package com.dyagilevaskripko.crystallball.mainwindow;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * TODO add comment
 */
public class MainWindowController
{
    private MainWindowView mainWindowView;

    public  MainWindowController()
    {
        HeaderView headerView = new HeaderView();
        CenterView centerView = new CenterView();
        BottomView bottomView = new BottomView();

        mainWindowView = new MainWindowView(headerView,centerView,bottomView);
    }

    public void show(Stage stage)
    {
        Scene mainScene = new Scene(mainWindowView,450,600);

        stage.setTitle("Crystal Ball");
        stage.setScene(mainScene);
        stage.show();
    }

}

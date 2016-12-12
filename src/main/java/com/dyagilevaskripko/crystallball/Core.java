package com.dyagilevaskripko.crystallball;

import com.dyagilevaskripko.crystallball.db.DataBase;
import javafx.stage.Stage;

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
        boolean connectionResult = DataBase.connection();

        if (connectionResult){
            DataBase.createTable();
            windowManager.showMainWindow(primaryStage);
        }

    }
}

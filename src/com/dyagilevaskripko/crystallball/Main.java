package com.dyagilevaskripko.crystallball;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Core core = new Core(primaryStage);
        core.execute();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

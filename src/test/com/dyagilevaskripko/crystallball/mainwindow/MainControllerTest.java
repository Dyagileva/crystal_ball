package com.dyagilevaskripko.crystallball.mainwindow;

import javafx.embed.swing.JFXPanel;
import javafx.scene.control.TextField;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by dyagi on 11.10.2016.
 */
public class MainControllerTest
{

    @BeforeClass
    public static void initToolkit()
            throws InterruptedException
    {
        final CountDownLatch latch = new CountDownLatch(1);
        SwingUtilities.invokeLater(() -> {
            new JFXPanel(); // initializes JavaFX environment
            latch.countDown();
        });

        // That's a pretty reasonable delay... Right?
        if (!latch.await(5L, TimeUnit.SECONDS))
            throw new ExceptionInInitializerError();
    }

    @Test
    public void checkIfValueOKTest()
    {
        MainView mainWindowView = new MainView();
        MainController mainController = new MainController(mainWindowView);

        TextField test = new TextField();
        TextField test1 = new TextField();
        test.setText("24");
        test1.setText("21");

        assertEquals(true, mainController.checkIfValueOK(test, test1,new TextField("ses")));
    }

    @Test
    public void checkIfValueOKTestErrorOne()
    {
        MainView mainWindowView = new MainView();
        MainController mainController = new MainController(mainWindowView);

        TextField test = new TextField();
        TextField test1 = new TextField();
        test.setText("sdsd");
        test1.setText("21");

        assertEquals(false, mainController.checkIfValueOK(test, test1,new TextField("1")));
    }

    @Test
    public void checkIfValueOKTestErrorTwo()
    {
        MainView mainWindowView = new MainView();
        MainController mainController = new MainController(mainWindowView);

        TextField test = new TextField();
        TextField test1 = new TextField();
        test.setText("21");
        test1.setText("sds");

        assertEquals(false, mainController.checkIfValueOK(test, test1,new TextField("ses")));
    }

}

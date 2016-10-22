package com.dyagilevaskripko.crystallball.mainwindow;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.control.TextField;
import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.annotations.BeforeMethod;

import javax.swing.*;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by dyagi on 11.10.2016.
 */
public class MainWindowControllerTest {

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
        MainWindowView mainWindowView = new MainWindowView();
        MainWindowController mainWindowController = new MainWindowController(mainWindowView);

        TextField test = new TextField();
        TextField test1 = new TextField();
        test.setText("24");
        test1.setText("21");

        assertEquals(true,mainWindowController.checkIfValueOK(test,test1));
    }

    @Test
    public void checkIfValueOKTestErrorOne()
    {
        MainWindowView mainWindowView = new MainWindowView();
        MainWindowController mainWindowController = new MainWindowController(mainWindowView);

        TextField test = new TextField();
        TextField test1 = new TextField();
        test.setText("sdsd");
        test1.setText("21");

        assertEquals(false,mainWindowController.checkIfValueOK(test,test1));
    }

    @Test
    public void checkIfValueOKTestErrorTwo()
    {
        MainWindowView mainWindowView = new MainWindowView();
        MainWindowController mainWindowController = new MainWindowController(mainWindowView);

        TextField test = new TextField();
        TextField test1 = new TextField();
        test.setText("21");
        test1.setText("sds");

        assertEquals(false,mainWindowController.checkIfValueOK(test,test1));
    }

}

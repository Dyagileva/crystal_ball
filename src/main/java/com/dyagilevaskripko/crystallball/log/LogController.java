package com.dyagilevaskripko.crystallball.log;

import com.dyagilevaskripko.crystallball.Result;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;


public class LogController
{
    private TableView<Result> commandTableView = new TableView<>();
    private VBox view;
    private ObservableList<Result> resultObservableList = FXCollections.observableArrayList();
    private LogColumnFactory logColumnFactory = new LogColumnFactory();

    public LogController()
    {
        this.view = new VBox();

        this.view.setId("tableViewVBox");
        this.view.setPrefHeight(200);

        Label logLabel = new Label("Random history");
        logLabel.setId("logLabel");
        initialize();

        VBox.setVgrow(this.view, Priority.ALWAYS);
        VBox.setVgrow(commandTableView, Priority.ALWAYS);
        this.view.getChildren().addAll(logLabel, commandTableView);

        this.view.getStylesheets().add("style/LogController.css");
    }

    @SuppressWarnings("unchecked")
    private void initialize()
    {
        commandTableView.setId("commandTableView");
        commandTableView.setItems(resultObservableList);
        commandTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        commandTableView.setFocusTraversable(false);
        commandTableView.setPlaceholder(new Label(""));

        commandTableView.getColumns()
                .addAll(logColumnFactory.createNameColumn(),
                        logColumnFactory.createTimeColumn(),
                        logColumnFactory.createNumberColumn());
    }

    public VBox getView()
    {
        return view;
    }

    public ObservableList<Result> getResultObservableList()
    {
        return resultObservableList;
    }
}

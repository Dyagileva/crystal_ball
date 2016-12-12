package com.dyagilevaskripko.crystallball.log;

import com.dyagilevaskripko.crystallball.Result;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalTime;

public class LogColumnFactory
{
    public TableColumn<Result, String> createNameColumn()
    {
        TableColumn<Result, String> result = new TableColumn<>("Name");
        result.setCellValueFactory(new PropertyValueFactory<>("name"));
        result.getStyleClass().add("nameColumn");

        return result;
    }

    public TableColumn<Result, LocalTime> createTimeColumn()
    {
        TableColumn<Result, LocalTime> result = new TableColumn<>("time");
        result.setCellValueFactory(new PropertyValueFactory<>("time"));
        result.getStyleClass().add("timeColumn");

//        result.setCellFactory(param -> new LogColumnTimeCell());

        return result;
    }

    public TableColumn<Result, Integer> createNumberColumn()
    {
        TableColumn<Result, Integer> result = new TableColumn<>("Value");
        result.setCellValueFactory(new PropertyValueFactory<>("number"));
        result.getStyleClass().add("numberColumn");

//        result.setCellFactory(param -> new CommandLogColumnStartDateCell());

        return result;
    }
}

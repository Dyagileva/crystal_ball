package com.dyagilevaskripko.crystallball.db;

import com.dyagilevaskripko.crystallball.Result;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DataBase
{
    private static Connection connection;
    private static Statement statement;

    public static boolean connection()
    {
        try
        {
            connection = null;
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:crystalldb.s3db");
            statement = connection.createStatement();
            System.out.println("База Подключена!");

            return true;
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("Ошибка!");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Ошибка!");
        }

        return false;
    }

    public static void createTable()
    {
        String sqlCommand = "CREATE TABLE if not exists 'results' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'name' text, 'time' TIME ,'number' INT);";

        try
        {
            statement.execute(sqlCommand);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Ошибка! Таблица не создана");
        }
    }

    public static void insert(Result result)
    {
        String valuesString = String.format("'%s','%s','%s'", result.getName(), result.getTime(), result.getNumber());
        String sqlCommand = "INSERT  INTO 'results' ('name','time','number') VALUES (" + valuesString + ");";

        try
        {
            statement.execute(sqlCommand);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Ошибка! Данные не добавлены");
        }
    }

    public static ObservableList<Result> read()
    {
        ObservableList<Result> resultObservableList = FXCollections.observableArrayList();
        ResultSet resultSet;

        try
        {
            resultSet = statement.executeQuery("SELECT * FROM results");
            while (resultSet.next())
            {
                Result result = new Result();

                result.setName(resultSet.getString("name"));
                result.setTime(resultSet.getString("time"));
                result.setNumber(resultSet.getInt("number"));

                resultObservableList.add(result);
            }

            System.out.println("Таблица успешно прочитана");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Ошибка! Таблица не прочитана");
        }

        return resultObservableList;
    }

    public static void close()
    {
        try
        {
            statement.close();
            connection.close();
            System.out.println("Соединения закрыты");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            System.out.println("Ошибка! Соединения не закрыты");
        }
    }
}

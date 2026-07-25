package db;

import exception.DBException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection connection = null;

    public static Connection getConnection(){

        try {
            if (connection == null) {
                Properties properties = loadProperties();
                String url = properties.getProperty("dburl");
                connection = DriverManager.getConnection(url, properties);
            }
        }catch (SQLException e){
            throw new DBException(e.getMessage());
        }
        return connection;
    }

    private static Properties loadProperties(){
        try(FileInputStream fileInputStream = new FileInputStream("db.properties")){
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties;
        }catch (IOException e){
            throw new DBException(e.getMessage());
        }
    }

    public static void closeStatment(Statement statement){
        try {
            statement.close();
        } catch (SQLException e) {
            throw new DBException(e.getMessage());
        }
    }

    public static void closeResultSet(ResultSet resultSet){
        try{
            resultSet.close();
        }catch (SQLException e){
            throw new DBException(e.getMessage());
        }
    }

    public static void closeConnection(){
        if(connection != null){
            try{
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

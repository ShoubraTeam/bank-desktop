package com.bank.controllers;

import com.bank.database.DatabaseProvider;
import com.bank.services.EntityService;
import com.bank.utils.Dialog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import java.sql.*;
import java.util.*;

public class ATMController {
    public static Object[][] data = null;
    public static  Object[] columns_name = null;

    public static void add(ArrayList<String> values) { // ["location", "balance", "capacity", "atm_type"]
        String insertSQL = "INSERT INTO atm(location, balance, capacity, atm_type) values(?,?::numeric,?::numeric,?::atm_type)";
        EntityService.insert(insertSQL, values, "Added ATM successfully!", "Unable to create a ATM: ");
    }

    public static ArrayList<String> getAllIds() {
        return EntityService.getAllIds("atm", "atm_id");
    }

    public static void getAll() {
        String selectSQL = "SELECT * FROM atm";
        try (Connection connection = DatabaseProvider.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Process the result set
                while (resultSet.next()) {
                    int id = resultSet.getInt("atm_id");
                    String location = resultSet.getString("location");
                    String atmType = resultSet.getString("atm_type");
                    String capacity = resultSet.getString("capacity");
                    String balance = resultSet.getString("balance");
                    String status = resultSet.getString("status");

                    // Output the result
                    System.out.printf("ID: %d, Location: %s, ATM Type: %s, Capacity: %s, Balance: %s, ATM Type: %s, Status: %s%n", id, location, atmType, capacity, balance, atmType, status);
                }
            }
        } catch (Exception err) {
            Dialog.showErrorMessage("Failed to get all ATMs: " + err.getMessage());
        }
    }

    public static void delete(String id) {
        String deleteSQL = "DELETE FROM atm WHERE atm_id = ?::numeric";
        try (Connection connection = DatabaseProvider.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setString(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                Dialog.showSuccessfulMessage("Removed ATM");
            }
            else {
                Dialog.showSuccessfulMessage("No thing to delete");
            }
        } catch (Exception err) {
            Dialog.showErrorMessage("Failed to remove ATM: " + err.getMessage());
        }
    }
    public static void QueryFourteen(int input) {

        int rows;
        int columns = 0;
        String query =  "SELECT * FROM atm WHERE atm_id IN (SELECT atm_id FROM transaction WHERE amount > " + input + " AND created_at >= CURRENT_DATE - INTERVAL '1 month')";
        try {
            // Load the MySQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Establish connection
            Connection connection = DatabaseProvider.getDataSource().getConnection();
            System.out.println("Connected to the database!");

            // Create a statement object to execute the query
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, // Enables scrolling
                    ResultSet.CONCUR_READ_ONLY         // Read-only ResultSet
            );

            // Execute the query and get the result set
            ResultSet resultSet = statement.executeQuery(query);

            // Get metadata to dynamically fetch column names
            ResultSetMetaData metaData = resultSet.getMetaData();
            columns = metaData.getColumnCount();

            resultSet.last();                                   // move the pointer of result set to the last element.
            rows = resultSet.getRow();                          // get the number of rows.
            resultSet.beforeFirst();                            // return the pointer of result set to the beginning
            columns_name = new Object[columns];                 // create an array to store columns name.

            // collecting column name
            for (int i = 0; i < columns; i++) {
                columns_name[i] = metaData.getColumnLabel(i + 1);
            }

            // Collect the result data
            data = new Object[rows][columns];

            // Iterate through the result set and store each one
            int counter = 0;
            while (resultSet.next()) {
                for (int i = 0; i < columns; i++) {
                    data[counter][i] = resultSet.getObject(i + 1);
                }
                counter++;
            }

            resultSet.setFetchSize(rows); // fetch all rows

            // Close the resources and statement and connection.
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Query executed successfully!");
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void QueryFifteen(int input) {

        int rows;
        int columns = 0;
        String query = "SELECT * FROM atm WHERE atm_id NOT IN (SELECT atm_id FROM transaction WHERE created_at >= CURRENT_DATE - INTERVAL '" + input + " months')";
        try {
            // Load the MySQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Establish connection
            Connection connection = DatabaseProvider.getDataSource().getConnection();
            System.out.println("Connected to the database!");

            // Create a statement object to execute the query
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, // Enables scrolling
                    ResultSet.CONCUR_READ_ONLY         // Read-only ResultSet
            );

            // Execute the query and get the result set
            ResultSet resultSet = statement.executeQuery(query);

            // Get metadata to dynamically fetch column names
            ResultSetMetaData metaData = resultSet.getMetaData();
            columns = metaData.getColumnCount();

            resultSet.last();                                   // move the pointer of result set to the last element.
            rows = resultSet.getRow();                          // get the number of rows.
            resultSet.beforeFirst();                            // return the pointer of result set to the beginning
            columns_name = new Object[columns];                 // create an array to store columns name.

            // collecting column name
            for (int i = 0; i < columns; i++) {
                columns_name[i] = metaData.getColumnLabel(i + 1);
            }

            // Collect the result data
            data = new Object[rows][columns];

            // Iterate through the result set and store each one
            int counter = 0;
            while (resultSet.next()) {
                for (int i = 0; i < columns; i++) {
                    data[counter][i] = resultSet.getObject(i + 1);
                }
                counter++;
            }

            resultSet.setFetchSize(rows); // fetch all rows

            // Close the resources and statement and connection.
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Query executed successfully!");
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
        }
    }

    public static void QuerySixteen() {

        int rows;
        int columns = 0;
        String query = "SELECT atm_id, AVG(amount) AS Averagre_Balance FROM transaction GROUP BY atm_id";
        try {
            // Load the MySQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Establish connection
            Connection connection = DatabaseProvider.getDataSource().getConnection();
            System.out.println("Connected to the database!");

            // Create a statement object to execute the query
            Statement statement = connection.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, // Enables scrolling
                    ResultSet.CONCUR_READ_ONLY         // Read-only ResultSet
            );

            // Execute the query and get the result set
            ResultSet resultSet = statement.executeQuery(query);

            // Get metadata to dynamically fetch column names
            ResultSetMetaData metaData = resultSet.getMetaData();
            columns = metaData.getColumnCount();

            resultSet.last();                                   // move the pointer of result set to the last element.
            rows = resultSet.getRow();                          // get the number of rows.
            resultSet.beforeFirst();                            // return the pointer of result set to the beginning
            columns_name = new Object[columns];                 // create an array to store columns name.

            // collecting column name
            for (int i = 0; i < columns; i++) {
                columns_name[i] = metaData.getColumnLabel(i + 1);
            }

            // Collect the result data
            data = new Object[rows][columns];

            // Iterate through the result set and store each one
            int counter = 0;
            while (resultSet.next()) {
                for (int i = 0; i < columns; i++) {
                    data[counter][i] = resultSet.getObject(i + 1);
                }
                counter++;
            }

            resultSet.setFetchSize(rows); // fetch all rows

            // Close the resources and statement and connection.
            resultSet.close();
            statement.close();
            connection.close();
            System.out.println("Query executed successfully!");
        } catch (ClassNotFoundException | SQLException exception) {
            exception.printStackTrace();
        }
    }
}




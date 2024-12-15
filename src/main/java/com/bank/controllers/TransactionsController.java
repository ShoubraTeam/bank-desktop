package com.bank.controllers;

import com.bank.database.DatabaseProvider;
import com.bank.services.EntityService;
import com.bank.utils.Dialog;

import java.sql.*;
import java.util.ArrayList;

public class TransactionsController {
    public static Object[][] data = null;
    public static  Object[] columns_name = null;
    public static void add(ArrayList<String> values) { // ["atm_id", "accountid", "amount", "description", "transaction_type"]
        String insertSQL = "INSERT INTO transaction(atm_id, accountid, amount, description, transaction_type) values(?::numeric, ?::numeric, ?::numeric, ?, ?::transaction_type)";
        EntityService.insert(insertSQL, values, "Added transaction successfully!", "Unable to create a transaction: ");
    }

    public static void delete(String id) {
        String deleteSQL = "DELETE FROM transaction WHERE id = ?::numeric";
        try (Connection connection = DatabaseProvider.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setString(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                Dialog.showSuccessfulMessage("Removed Transaction");
            }
        } catch (Exception err) {
            Dialog.showErrorMessage("Failed to remove Transaction: " + err.getMessage());
        }
    }

    public static void QueryNine(int input) {
        int rows;
        int columns = 0;
        String query = "SELECT transaction_date, SUM(amount) FROM transactions WHERE transaction_date >= CURRENT_DATE - INTERVAL '" + input + " days' GROUP BY transaction_date";
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
    public static void QueryTen(int input) {
        int rows;
        int columns = 0;
        String query = "SELECT * FROM transaction WHERE created_at >= CURRENT_DATE - INTERVAL '1 year' ORDER BY amount DESC LIMIT " + input;
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

    public static void QueryEleven() {
        int rows;
        int columns = 0;
        String query =  "SELECT customer_id, SUM(amount) FROM transaction WHERE created_at >= CURRENT_DATE - INTERVAL '1 month' GROUP BY customer_id";
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

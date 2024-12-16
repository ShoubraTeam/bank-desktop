package com.bank.controllers;

import com.bank.database.DatabaseProvider;
import com.bank.services.EntityService;
import com.bank.utils.Dialog;

import java.sql.*;
import java.util.ArrayList;

public class BranchController {
    public static Object[][] data = null;
    public static  Object[] columns_name = null;
    public static void add(ArrayList<String> values) { // ["location", "phone", "type"]
        String insertSQL = "INSERT INTO branch(location, phone_number, type) values(?,?,?::branch_type)";
        EntityService.insert(insertSQL, values, "Added branch successfully!", "Unable to create a branch: ");
    }

    public static ArrayList<String> getAllIds() {
        return EntityService.getAllIds("branch", "branch_id");
    }

    public static void delete(String id) {
        String deleteSQL = "DELETE FROM branch WHERE branch_id = ?::numeric";
        try (Connection connection = DatabaseProvider.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setString(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                Dialog.showSuccessfulMessage("Removed Branch");
            }
            else {
                Dialog.showSuccessfulMessage("No thing to delete");
            }
        } catch (Exception err) {
            Dialog.showErrorMessage("Failed to remove Branch: " + err.getMessage());
        }
    }

    public static void QuerySeventeen() {

        int rows;
        int columns = 0;
        String query ="SELECT b.branch_id, b.location, COUNT(ba.account_id) AS num_accounts FROM branch b JOIN customer c ON b.branch_id = c.branch_id JOIN bank_account ba ON c.national_id = ba.customer_id GROUP BY b.branch_id, b.location ORDER BY num_accounts DESC LIMIT 1";
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


    public static void QueryEighteen() {

        int rows;
        int columns = 0;
        String query = "SELECT b.branch_id, b.location, l.loan_id, l.amount, l.created_at FROM branch b JOIN customer c ON b.branch_id = c.branch_id JOIN loan l ON c.national_id = l.customer_id WHERE l.created_at >= CURRENT_DATE - INTERVAL '1 month' ORDER BY b.branch_id, l.created_at;";
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


    public static void QueryNineteen(int input) {

        int rows;
        int columns = 0;
        String query = "SELECT b.branch_id, b.location, SUM(ba.balance) AS total_balance FROM branch b JOIN customer c ON b.branch_id = c.branch_id JOIN bank_account ba ON c.national_id = ba.customer_id GROUP BY b.branch_id, b.location HAVING SUM(ba.balance) >" + input;
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

package com.bank.controllers;

import com.bank.database.DatabaseProvider;
import com.bank.utils.Dialog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class ATMController {
    public static void add(ArrayList<String> values) { // ["location", "balance", "capacity", "atm_type"]
        String insertSQL = "INSERT INTO atm(location, balance, capacity, atm_type) values(?,?::numeric,?::numeric,?::atm_type)";
        try (Connection connection = DatabaseProvider.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            int index = 1;
            for (String v : values) {
                preparedStatement.setString(index++, v);
            }
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                Dialog.showSuccessfulMessage("Added ATM successfully!");
            }
        } catch (Exception err) {
            Dialog.showErrorMessage("Failed to add ATM: " + err.getMessage());
        }
    }

    public static void update(LinkedHashMap<String, Object> values) {
        String wherekey = "";
        if (!values.isEmpty()) {
            StringBuilder setClause = new StringBuilder();
            int count = 0;
            for (String column : values.keySet()) {
                if (count == 0) {
                    wherekey = column;
                    count++;
                } else {
                    if (setClause.length() > 0) {
                        setClause.append(", ");
                    }
                    setClause.append(column).append(" = ?");
                }
            }
            String updateSQL = "UPDATE ATM SET " + setClause.toString() + " WHERE " + wherekey + " = ?";
            try (Connection connection = DatabaseProvider.getDataSource().getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {

                int index = 1;
                count = 0;
                for (Object value : values.values()) {
                    if (count == 0) {
                        count++;
                    } else {
                        preparedStatement.setObject(index++, Integer.parseInt(value.toString()));  // Set value in order of appearance
                    }
                }
                preparedStatement.setObject(index++, Integer.parseInt(values.get(wherekey).toString()));  // Set value in order of appearance




                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    Dialog.showSuccessfulMessage("Update ATM successfully!");
                }
            } catch (Exception err) {
                Dialog.showErrorMessage("Failed to update ATM: " + err.getMessage());
            }
        } else {
            Dialog.showErrorMessage("Please select attribute to modify ");
        }
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
        } catch (Exception err) {
            Dialog.showErrorMessage("Failed to remove ATM: " + err.getMessage());
        }
    }
}

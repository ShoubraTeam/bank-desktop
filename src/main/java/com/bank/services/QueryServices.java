package com.bank.services;

import com.bank.database.DatabaseProvider;
import com.bank.utils.Dialog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class QueryServices {;
        public static void runQuery(String sql, String successMessage, String errorMessage) {
            try (Connection connection = DatabaseProvider.getDataSource().getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) { // NOTE: unsafe (sql injection) but ok for this kind of educational application
                int index = 1;

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    Dialog.showSuccessfulMessage(successMessage);
                }
            } catch (Exception err) {
                Dialog.showErrorMessage(errorMessage + err.getMessage());
            }
        }

        public static ArrayList<String> getAllIds(String tableName, String idColumnName) {
            ArrayList<String> ids = new ArrayList<>();
            String selectSQL = "SELECT * FROM " + tableName;
            try (Connection connection = DatabaseProvider.getDataSource().getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) { // NOTE: unsafe (sql injection) but ok for this kind of educational application
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        ids.add(resultSet.getString(idColumnName));
                    }
                }
            } catch (Exception err) {
                Dialog.showErrorMessage("Failed to get all IDs: " + err.getMessage());
            }
            return ids;
        }
    }



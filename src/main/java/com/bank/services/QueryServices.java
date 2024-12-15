package com.bank.services;

import com.bank.database.DatabaseProvider;
import com.bank.utils.Dialog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class QueryServices {
    ;

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

    public static void update(LinkedHashMap<String, Object> values, String tabalName) {
        String wherekey = "";
        if (values.size() > 1) {
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
            String updateSQL = "UPDATE " + tabalName + " SET " + setClause.toString() + " WHERE " + wherekey + " = ?";
            try (Connection connection = DatabaseProvider.getDataSource().getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {

                int index = 1;
                count = 0;
                for (Object value : values.values()) {
                    if (count == 0) {
                        count++;
                    } else {
                        preparedStatement.setObject(index++, value);
                    }
                }
                preparedStatement.setObject(index, values.get(wherekey));

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    Dialog.showSuccessfulMessage("Update ATM successfully!");
                } else {
                    Dialog.showSuccessfulMessage("This Row is not in the Date Base");
                }
            } catch (Exception err) {
                Dialog.showErrorMessage("Failed to update ATM: " + err.getMessage());
            }
        } else {
            Dialog.showErrorMessage("Please select attribute to modify ");
        }
    }

}



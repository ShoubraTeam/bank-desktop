package com.bank.controllers;

import com.bank.database.DatabaseProvider;
import com.bank.utils.Dialog;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TransfersController {
    public static void delete(String id) {
        String deleteSQL = "DELETE FROM transfers WHERE id = ?::numeric";
        try (Connection connection = DatabaseProvider.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setString(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                Dialog.showSuccessfulMessage("Removed Transfer");
            }
        } catch (Exception err) {
            Dialog.showErrorMessage("Failed to remove Transfer: " + err.getMessage());
        }
    }
}

package com.bank.controllers;

import com.bank.database.DatabaseProvider;
import com.bank.utils.Dialog;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BranchController {
    public static void delete(String id) {
        String deleteSQL = "DELETE FROM branch WHERE branch_id = ?::numeric";
        try (Connection connection = DatabaseProvider.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setString(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                Dialog.showSuccessfulMessage("Removed Branch");
            }
        } catch (Exception err) {
            Dialog.showErrorMessage("Failed to remove Branch: " + err.getMessage());
        }
    }
}

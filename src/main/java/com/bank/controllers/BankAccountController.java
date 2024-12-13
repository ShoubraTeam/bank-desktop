package com.bank.controllers;

import com.bank.database.DatabaseProvider;
import com.bank.utils.Dialog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class BankAccountController {
    public static void delete(String id) {
        String deleteSQL = "DELETE FROM bank_account WHERE accountid = ?::numeric";
        try (Connection connection = DatabaseProvider.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setString(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                Dialog.showSuccessfulMessage("Removed Bank Account");
            }
        } catch (Exception err) {
            Dialog.showErrorMessage("Failed to remove Bank Account: " + err.getMessage());
        }
    }
}
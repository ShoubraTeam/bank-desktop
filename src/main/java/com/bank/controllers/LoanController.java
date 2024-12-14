package com.bank.controllers;

import com.bank.database.DatabaseProvider;
import com.bank.services.EntityService;
import com.bank.utils.Dialog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class LoanController {
    public static void add(ArrayList<String> values) { // ["customer_id", "amount", "reason", "assurance", "num_of_months"]
        String insertSQL = "INSERT INTO loan(customer_id, amount, reason, assurance, num_of_months) values(?::numeric, ?::numeric, ?, ?::numeric, ?::numeric)";
        EntityService.insert(insertSQL, values, "Added loan successfully!", "Unable to create a loan: ");
    }

    public static void delete(String id) {
        String deleteSQL = "DELETE FROM loan WHERE loan_id = ?::numeric";
        try (Connection connection = DatabaseProvider.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setString(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                Dialog.showSuccessfulMessage("Removed Loan");
            }
        } catch (Exception err) {
            Dialog.showErrorMessage("Failed to remove Loan: " + err.getMessage());
        }
    }
}

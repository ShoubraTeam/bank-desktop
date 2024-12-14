package com.bank.controllers;

import com.bank.database.DatabaseProvider;
import com.bank.services.EntityService;
import com.bank.utils.Dialog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class TransactionsController {
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
}

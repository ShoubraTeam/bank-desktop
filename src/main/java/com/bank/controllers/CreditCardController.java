package com.bank.controllers;

import com.bank.database.DatabaseProvider;
import com.bank.services.EntityService;
import com.bank.utils.Dialog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class CreditCardController {
    public static void add(ArrayList<String> values) { // ["location", "balance", "capacity", "atm_type"]
        String insertSQL = "INSERT INTO credit_card(accountid, cardnumber, balance, cvc, pin, cardtype) values(?::numeric, ?, ?::numeric, ?, ?, ?::cardtype_type)";
        EntityService.insert(insertSQL, values, "Added credit card successfully!", "Unable to create a credit card: ");
    }

    public static void delete(String id) {
        String deleteSQL = "DELETE FROM credit_card WHERE cardnumber= ?::numeric";
        try (Connection connection = DatabaseProvider.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setString(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                Dialog.showSuccessfulMessage("Removed Credit Card");
            }
        } catch (Exception err) {
            Dialog.showErrorMessage("Failed to remove Credit Card: " + err.getMessage());
        }
    }
}

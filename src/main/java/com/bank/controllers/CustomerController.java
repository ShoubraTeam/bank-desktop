package com.bank.controllers;

import com.bank.database.DatabaseProvider;
import com.bank.services.EntityService;
import com.bank.utils.Dialog;

import javax.swing.text.html.parser.Entity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CustomerController {
    public static void add(ArrayList<String> values) { // ["branch_id", "national_id", "f_name", "l_name", "birthdate", "address", "email", "phone", "dead"]
        String insertSQL = "INSERT INTO customer(branch_id, national_id, f_name, l_name, birthdate, address, email, phone, dead) values(?::integer, ?, ?, ?, ?::date, ?, ?, ?, ?::boolean)";
        EntityService.insert(insertSQL, values, "Added customer successfully!", "Unable to create a customer: ");
    }

    public static ArrayList<String> getAllIds() {
        return EntityService.getAllIds("customer", "national_id");
    }

    public static void delete(String id) {
        String deleteSQL = "DELETE FROM customer WHERE national_id = ?::numeric";
        try (Connection connection = DatabaseProvider.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL)) {
            preparedStatement.setString(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                Dialog.showSuccessfulMessage("Removed Customer");
            }
        } catch (Exception err) {
            Dialog.showErrorMessage("Failed to remove Customer: " + err.getMessage());
        }
    }
}

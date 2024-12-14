package com.bank.controllers;

import com.bank.database.DatabaseProvider;
import com.bank.services.EntityService;
import com.bank.services.QueryServices;
import com.bank.utils.Dialog;
import com.bank.views.forms.Form;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
public class QueriesController extends Form {
    private static JPanel tablePanel;
    public static void getRecentCustomers(int months) {
        // حساب التاريخ X أشهر ماضية (بدون الوقت)
        LocalDate dateXMonthsAgo = LocalDate.now().minusMonths(months);
        // تحويل LocalDate إلى java.sql.Date (تاريخ بدون وقت)
        java.sql.Date date = java.sql.Date.valueOf(dateXMonthsAgo);

        // تعديل الاستعلام للتعامل مع DATE بدلاً من TIMESTAMP
        String selectSQL = "SELECT National_id, f_name, l_name, email, joined_at " +
                "FROM customer WHERE joined_at >= ?";

        try (Connection connection = DatabaseProvider.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {

            // توضيح المعامل الممرر في الاستعلام (لأغراض التحقق)
            System.out.println("Query parameter (date from " + months + " months ago): " + date);

            preparedStatement.setInt(1, months);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (!resultSet.isBeforeFirst()) { // التحقق من عدم وجود نتائج
                    System.out.println("No recent customers found.");
                    return;
                }

                // معالجة النتائج
                while (resultSet.next()) {
                    int National_id = resultSet.getInt("National_id");
                    String F_name = resultSet.getString("f_name");
                    String L_name = resultSet.getString("l_name");
                    String email = resultSet.getString("email");
                    Date joined_at = resultSet.getDate("joined_at");

                    // طباعة النتائج
                    System.out.printf("Customer ID: %d, Name: %s %s, Email: %s, Join Date: %s%n",
                            National_id, F_name, L_name, email, joined_at);
                }
            }
        } catch (Exception err) {
            Dialog.showErrorMessage("Failed to get recent customers: " + err.getMessage());
            err.printStackTrace();
        }
    }
    public static void getCustomersWithoutBankAccounts () {
        String selectSQL2 = "SELECT c.National_id, c.f_name, c.l_name, c.email, c.joined_at " +
                "FROM customer c " +
                "LEFT JOIN bank_account b ON c.National_id = c.National_id " +
                "WHERE c.National_id IS NULL";
        QueryServices.runQuery(selectSQL2, "Added transaction successfully!", "Unable to run query ");
        try (Connection connection = DatabaseProvider.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL2)) {
            try (ResultSet resultSet = preparedStatement.executeQuery()) {

              while (resultSet.next()) {
                    int National_id = resultSet.getInt("National_id");
                    String F_name = resultSet.getString("f_name");
                    String L_name = resultSet.getString("l_name");
                    String email = resultSet.getString("email");
                    Date joined_at = resultSet.getDate("joined_at");

                    // طباعة النتائج
                    System.out.printf("Customer ID: %d, Name: %s %s, Email: %s, Join Date: %s%n",
                      National_id, F_name, L_name, email, joined_at);
                }
            }
        } catch (Exception err) {
            Dialog.showErrorMessage("Failed to get customers without bank accounts: " + err.getMessage());
            err.printStackTrace();
        }

    }

    public static void getAccountsBelowAverageBalance() {
        // Query to get the accounts with a balance below the average balance
        String selectSQL = "SELECT b.accountid, b.national_id, b.balance " +
                "FROM bank_account b " +
                "WHERE b.balance < (SELECT AVG(balance) FROM bank_account)";

        // Run the query using the QueryServices utility (optional, based on your code structure)
        QueryServices.runQuery(selectSQL, "Accounts with balance below average fetched successfully!",
                "Unable to run query to fetch accounts below average balance");

        // Execute the query and process the results
        try (Connection connection = DatabaseProvider.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                // Check if results are available
                if (!resultSet.isBeforeFirst()) {
                    System.out.println("No accounts with balance below the average were found.");
                    return;
                }

                // Iterate through the result set and print the account details
                while (resultSet.next()) {
                    int account_id = resultSet.getInt("account_id");
                    int customer_id = resultSet.getInt("customer_id");
                    double balance = resultSet.getDouble("balance");

                    // Print the account details
                    System.out.printf("Account ID: %d, Customer ID: %d, Balance: %.2f%n",
                            account_id, customer_id, balance);
                }
            }
        } catch (Exception err) {
            // Handle any errors and display a message
            Dialog.showErrorMessage("Failed to get accounts with balance below average: " + err.getMessage());
            err.printStackTrace();
        }
    }
    public static void getTotalBalanceOfAllAccounts() {
        // Query to get the accounts with a balance below the average balance
        String selectSQL = "SELECT SUM(balance) AS total_balance FROM bank_account";

        // Run the query using the QueryServices utility (optional, based on your code structure)
        QueryServices.runQuery(selectSQL, "Accounts total balance fetched successfully!",
                "Unable to run query to fetch accounts ");

        // Execute the query and process the results
        try (Connection connection = DatabaseProvider.getDataSource().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {

            try (ResultSet resultSet = preparedStatement.executeQuery()) {

                // Check if results are available
                if (!resultSet.isBeforeFirst()) {
                    System.out.println("No accounts  were found.");
                    return;
                }

                // Iterate through the result set and print the account details
                while (resultSet.next()) {
                    int account_id = resultSet.getInt("account_id");
                    int customer_id = resultSet.getInt("customer_id");
                    double balance = resultSet.getDouble("balance");

                    // Print the account details
                    System.out.printf("Account ID: %d, Customer ID: %d, Balance: %.2f%n",
                            account_id, customer_id, balance);
                }
            }
        } catch (Exception err) {
            // Handle any errors and display a message
            Dialog.showErrorMessage("Failed to get accounts  " + err.getMessage());
            err.printStackTrace();
        }
    }

}

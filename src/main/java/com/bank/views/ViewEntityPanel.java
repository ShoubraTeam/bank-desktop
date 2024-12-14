package com.bank.views;

import com.bank.config.Colors;
import com.bank.database.DatabaseProvider;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * A panel that represents the "View Entity" page of the application.
 * <p>
 * This class extends {@link JPanel} and provides the foundation
 * for displaying entities in the system. Currently, it includes
 * a title label displaying "View Entity".
 * </p>
 */
public class ViewEntityPanel extends JPanel {
    private JPanel tablePanel; // Panel to hold the table
    private JPanel fetchPanel; // Panel for the comboBox and fetch button

    public ViewEntityPanel() {
        setLayout(new BorderLayout()); // Main layout for the panel

        // Title Panel
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.setBorder(new EmptyBorder(23, 10, 10, 10)); // Padding for title
        JLabel titleLabel = new JLabel("View Entity");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titlePanel.add(titleLabel);

        // ComboBox Panel with Fetch Button
        fetchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fetchPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Padding for comboBox
        JLabel entityTypeLabel = new JLabel("Entity Type");
        JComboBox<String> comboBox = new JComboBox<>(new String[]{
                "ATM", "Branch", "Customer", "Loan", "credit_card", "Transfers", "Transaction","bank_account"
        });
        comboBox.setPreferredSize(new Dimension(700, 50));
        comboBox.setBackground(Colors.SECONDARY_COLOR);
        comboBox.setFocusable(false);
        comboBox.setFont(new Font("Arial", Font.BOLD, 20));

        JButton fetchButton = new JButton("Fetch");
        fetchButton.setForeground(Colors.SECONDARY_COLOR);
        fetchButton.setFocusPainted(false);
        fetchButton.setBackground(Color.black);
        fetchButton.setFont(new Font("Arial", Font.BOLD, 20));


        fetchPanel.add(entityTypeLabel);
        fetchPanel.add(comboBox);
        fetchPanel.add(fetchButton);

        // Table Panel (Initially Hidden)
        tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // Padding for table
        tablePanel.setVisible(false); // Hide the table panel initially

        // Add components to the main panel
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS)); // Use BoxLayout for vertical alignment
        contentPanel.add(fetchPanel); // Add ComboBox and Fetch Button

        add(titlePanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER); // Add the combined panel to the center

        // Fetch Button Action to Show Table and Pagination
        fetchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tablePanel.removeAll();
                tablePanel.updateUI();

                /*
                 * comment from here
                 * */


                String query = "SELECT * FROM ";
                query += comboBox.getSelectedItem();
                System.out.println(query);

                Object[][] data = null;
                Object[] columns_name = null;
                int rows;
                int columns = 0;


                try {
                    // Load the MySQL JDBC driver
                    Class.forName("org.postgresql.Driver");

                    // Establish connection
                    Connection connection = DatabaseProvider.getDataSource().getConnection();
                    System.out.println("Connected to the database!");

                    // Create a statement object to execute the query
                    Statement statement = connection.createStatement(
                            ResultSet.TYPE_SCROLL_INSENSITIVE, // Enables scrolling
                            ResultSet.CONCUR_READ_ONLY         // Read-only ResultSet
                    );

                    // Execute the query and get the result set
                    ResultSet resultSet = statement.executeQuery(query);

                    // Get metadata to dynamically fetch column names
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    columns = metaData.getColumnCount();


                    /*
                     *   Start of new part
                     * this part get the columns name from metaData.
                     * */
                    resultSet.last();                                   // move the pointer of result set to the last element.
                    rows = resultSet.getRow();                          // get the number of rows.
                    System.out.println(rows);                           // print the number of rows in cmd for testing only
                    resultSet.beforeFirst();                            // return the pointer of result set to the beginning
                    columns_name = new Object[columns];                 // create an array to store columns name.

                    // collecting column name
                    try{
                        for (int i = 0; i < columns; i++){
                            columns_name[i] = metaData.getColumnLabel(i + 1);
                        }
                    }catch (SQLException ColumnNameException){
                        System.out.println("ColumnNameException");                  //ColumnNameException for debugging
                    }
                    // end of collecting column name

                    data = new Object[rows][columns];                               // creating a new array for data


                    // Iterate through the result set and store each one
                    int counter = 0;
                    while(resultSet.next()){
                        for (int i = 0 ; i < columns ; i++){
                            data[counter][i] = resultSet.getObject(i + 1);
                        }
                        counter++;
                    }

                    resultSet.setFetchSize(rows);               // this method used to determine the number of rows that I want to fetch, so I want to fetch all rows

                    // Close the resources and statement and connection.
                    resultSet.close();
                    statement.close();
                    connection.close();
                    System.out.println("Query executed successfully!");
                } catch (ClassNotFoundException classNotFoundException) {
                    System.err.println("classNotFoundException in ViewEntity");
                } catch (SQLException sqlException) {
                    System.err.println("sqlException in ViewEntity");
                }


                JTable table = new JTable(new DefaultTableModel(data,columns_name));
                JScrollPane scrollPane = new JScrollPane(table); // Add scrolling
                tablePanel.add(scrollPane, BorderLayout.CENTER);
                contentPanel.add(tablePanel); // Initially hidden Table

                tablePanel.setVisible(true); // Show the table panel
            }
        });
    }
}

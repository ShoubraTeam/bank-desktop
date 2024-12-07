package com.bank.config;

import com.bank.ui.ComboBox;
import com.bank.ui.Label;
import com.bank.ui.TextField;
import com.bank.views.forms.RowPanelTwoItems;

import javax.swing.*;
import java.awt.Component;

public class EntityConstants {
    /*
        ATM Constants
     */

    public static final String[] ATM_TYPES = {"Single", "Double"};
    public static final RowPanelTwoItems<?,?>[] ATM_ADD_ATTRIBUTES = new RowPanelTwoItems[] {
            new RowPanelTwoItems<Label, Component>(new Label("Location"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Balance"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Capacity"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("ATM Type"), new ComboBox(ATM_TYPES)),
    };

     /*
        Customer Constants
     */

    public static final RowPanelTwoItems<?,?>[] CUSTOMER_ADD_ATTRIBUTES = new RowPanelTwoItems[] {
            new RowPanelTwoItems<Label, Component>(new Label("National ID"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("First Name"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Last Name"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Birthdate"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Address"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Email"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Phone Number"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Dead"), new JCheckBox()),
    };

    /*
        Branch Constants
     */
    public static final String[] BRANCH_TYPE = {"Main", "Sub"};
    public static final RowPanelTwoItems<?,?>[] BRANCH_ADD_ATTRIBUTES = new RowPanelTwoItems[] {
            new RowPanelTwoItems<Label, Component>(new Label("Location"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Phone Number"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Branch Type"), new ComboBox(BRANCH_TYPE)),
    };

    /*
        Transaction Constants
     */
    public static final String[] TRANSACTION_TYPE = {"WITHDRAW", "DEPOSIT"};
    public static final RowPanelTwoItems<?,?>[] TRANSACTION_ADD_ATTRIBUTES = new RowPanelTwoItems[] {
            new RowPanelTwoItems<Label, Component>(new Label("Amount"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Description"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Transaction Type"), new ComboBox(TRANSACTION_TYPE)),
    };

    /*
        Credit Card Constants
    */
    public static final String[] CARD_TYPE = {"Debit", "Credit"};
    public static final RowPanelTwoItems<?,?>[] CREDIT_CARD_ADD_ATTRIBUTES = new RowPanelTwoItems[] {
            new RowPanelTwoItems<Label, Component>(new Label("Card Number"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Balance"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("CVC"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("PIN"), new TextField()),
            // TODO: add default value for expiration date: now() + 7 years
            // new RowPanelTwoItems<Label, Component>(new Label("Expiration date"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Card Type"), new ComboBox(CARD_TYPE)),
    };

    /*
        Transfers Constants
    */
    public static final RowPanelTwoItems<?,?>[] TRANSFER_ADD_ATTRIBUTES = new RowPanelTwoItems[] {
            new RowPanelTwoItems<Label, Component>(new Label("Amount"), new TextField()),
    };

    /*
        Bank Account Constants
    */
    public static final String[] ACCOUNT_TYPE = {"Savings", "Checking"};
    public static final RowPanelTwoItems<?,?>[] BANK_ACCOUNT_ADD_ATTRIBUTES = new RowPanelTwoItems[] {
            new RowPanelTwoItems<Label, Component>(new Label("Balance"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Account Type"), new ComboBox(ACCOUNT_TYPE)),
    };

    /*
        Loan Constants
    */
    public static final String[] LOAN_NUMBER_OF_MONTHS = {"12", "24", "36", "48", "60"};
    public static final RowPanelTwoItems<?,?>[] LOAN_ADD_ATTRIBUTES = new RowPanelTwoItems[] {
            new RowPanelTwoItems<Label, Component>(new Label("Amount"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Reason"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Assurance"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Number of months"), new ComboBox(LOAN_NUMBER_OF_MONTHS)),
            new RowPanelTwoItems<Label, Component>(new Label("Settled"), new JCheckBox()),
    };
}

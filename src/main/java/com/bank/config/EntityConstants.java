package com.bank.config;

import com.bank.ui.*;
import com.bank.ui.Label;
import com.bank.ui.TextField;
import com.bank.views.forms.RowPanelOneItem;
import com.bank.views.forms.RowPanelThreeItems;
import com.bank.views.forms.RowPanelTwoItems;

import javax.swing.*;
import java.awt.*;

public class EntityConstants {

    public static final String MODIFY_CONSTANT = "Modify";

    /*
        ATM Constants
     */

    public static final String[] ATM_TYPES = {"SINGLE", "DOUBLE"};

    public static final RowPanelTwoItems<?, ?>[] ATM_ADD_ATTRIBUTES = new RowPanelTwoItems[]{

            new RowPanelTwoItems<Label, Component>(new Label("Location"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Balance"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Capacity"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("ATM Type"), new ComboBox(ATM_TYPES)),
    };
    public static final RowPanelThreeItems<?, ?, ?>[] ATM_MODIFY_ATTRIBUTES = new RowPanelThreeItems[]{
            new RowPanelThreeItems<Label, Component, Component>(new Label("ATM_ID"), new TextField(), new JPanel()),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Balance"), new TextField(), new CheckBox(MODIFY_CONSTANT)),
    };

     /*
        Customer Constants
     */

    public static final RowPanelTwoItems<?, ?>[] CUSTOMER_ADD_ATTRIBUTES = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("National ID"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("First Name"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Last Name"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Birthdate"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Address"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Email"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Phone Number"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Dead"), new JCheckBox()),
    };
    public static final RowPanelThreeItems<?, ?, ?>[] CUSTOMER_MODIFY_ATTRIBUTES = new RowPanelThreeItems[]{

            new RowPanelThreeItems<Label, Component, Component>(new Label("National ID"), new TextField(), new JPanel()),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Address"), new TextField(), new CheckBox(MODIFY_CONSTANT)),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Email"), new TextField(), new CheckBox(MODIFY_CONSTANT)),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Phone Number"), new TextField(), new CheckBox(MODIFY_CONSTANT)),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Dead"), new JCheckBox(), new CheckBox(MODIFY_CONSTANT)),
    };

    /*
        Branch Constants
     */
    public static final String[] BRANCH_TYPE = {"Main", "Sub"};
    public static final RowPanelTwoItems<?, ?>[] BRANCH_ADD_ATTRIBUTES = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("Location"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Phone Number"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Branch Type"), new ComboBox(BRANCH_TYPE)),
    };
    public static final RowPanelTwoItems<?, ?>[] BRANCH_MODIFY_ATTRIBUTES = new RowPanelThreeItems[]{
            new RowPanelThreeItems<Label, Component, Component>(new Label("Branch ID"), new TextField(), new JPanel()),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Phone Number"), new TextField(), new CheckBox(MODIFY_CONSTANT)),
    };


    /*
        Transaction Constants
     */
    public static final String[] TRANSACTION_TYPE = {"WITHDRAW", "DEPOSIT"};
    public static final RowPanelTwoItems<?, ?>[] TRANSACTION_ADD_ATTRIBUTES = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("Amount"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Transaction Type"), new ComboBox(TRANSACTION_TYPE)),
    };
    public static final RowPanelThreeItems<?, ?, ?>[] TRANSACTION_MODIFY_ATTRIBUTES = new RowPanelThreeItems[]{
            new RowPanelThreeItems<Label, Component, Component>(new Label("Transaction ID"), new TextField(), new JPanel()),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Amount"), new TextField(), new CheckBox(MODIFY_CONSTANT)),
    };


    /*
        Credit Card Constants
    */
    public static final String[] CARD_TYPE = {"Debit", "Credit"};
    public static final RowPanelTwoItems<?, ?>[] CREDIT_CARD_ADD_ATTRIBUTES = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("Card Number"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Balance"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("CVC"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("PIN"), new TextField()),

            // new RowPanelTwoItems<Label, Component>(new Label("Expiration date"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Card Type"), new ComboBox(CARD_TYPE)),
    };
    public static final RowPanelThreeItems<?, ?, ?>[] CREDIT_CARD_MODIFY_ATTRIBUTES = new RowPanelThreeItems[]{
            new RowPanelThreeItems(new Label("Card Number"), new TextField(), new JPanel()),
            new RowPanelThreeItems(new Label("Balance"), new TextField(), new CheckBox(MODIFY_CONSTANT)),

    };

    /*
        Transfers Constants
    */
    public static final RowPanelTwoItems<?, ?>[] TRANSFER_ADD_ATTRIBUTES = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("Amount"), new TextField()),
    };


    /*
        Bank Account Constants
    */
    public static final String[] ACCOUNT_TYPE = {"Saving", "Checking"};
    public static final RowPanelTwoItems<?, ?>[] BANK_ACCOUNT_ADD_ATTRIBUTES = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("Balance"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Account Type"), new ComboBox(ACCOUNT_TYPE)),
    };

    public static final RowPanelThreeItems<?, ?, ?>[] BANK_ACCOUNT_MODIFY_ATTRIBUTES = new RowPanelThreeItems[]{
            new RowPanelThreeItems<Label, Component, Component>(new Label("Account ID"), new TextField(), new JPanel()),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Balance"), new TextField(), new CheckBox(MODIFY_CONSTANT)),
    };

    /*
        Loan Constants
    */
    public static final String[] LOAN_NUMBER_OF_MONTHS = {"12", "24", "36", "48", "60"};
    public static final RowPanelTwoItems<?, ?>[] LOAN_ADD_ATTRIBUTES = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("Amount"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Reason"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Assurance"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Number of months"), new ComboBox(LOAN_NUMBER_OF_MONTHS)),
    };

    public static final RowPanelThreeItems<?, ?, ?>[] LOAN_MODIFY_ATTRIBUTES = new RowPanelThreeItems[]{
            new RowPanelThreeItems<Label, Component, Component>(new Label("Loan ID"), new TextField(), new JPanel()),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Settled"), new JCheckBox(), new CheckBox(MODIFY_CONSTANT)),
    };

    public static final RowPanelTwoItems<?, ?>[] LOAN_DELETE_ATTRIBUTES = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("Loan ID"), new TextField()),

    };
    public static final RowPanelTwoItems<?, ?>[] BRANCH_DELETE_ATTRIBUTES = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("Branch ID"), new TextField()),

    };
    public static final RowPanelTwoItems<?, ?>[] CUSTOMER_DELETE_ATTRIBUTES = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("Customer National Number"), new TextField()),

    };
    public static final RowPanelTwoItems<?, ?>[] BANK_ACCOUNT_DELETE_ATTRIBUTES = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("Bank Account ID"), new TextField()),

    };
    public static final RowPanelTwoItems<?, ?>[] TRANSACTIONS_DELETE_ATTRIBUTES = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("Transactions ID"), new TextField()),

    };
    public static final RowPanelTwoItems<?, ?>[] TRANSFERS_DELETE_ATTRIBUTES = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("Transfers ID"), new TextField()),

    };
    public static final RowPanelTwoItems<?, ?>[] CREDIT_CARD_DELETE_ATTRIBUTES = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("Card Number"), new TextField()),

    };
    public static final RowPanelTwoItems<?, ?>[] ATM_DELETE_ATTRIBUTES = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("ATM ID"), new TextField()),

    };
    public static final RowPanelTwoItems<?, ?>[] QUERY_ONE = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("Customers who joined in the last X months."), new TextField()),

    };
    public static final RowPanelTwoItems<?, ?>[] QUERY_TWO = new RowPanelTwoItems[]{
    };
    public static final RowPanelTwoItems<?, ?>[] QUERY_THREE = new RowPanelTwoItems[]{
    };
    public static final RowPanelTwoItems<?, ?>[] QUERY_FOUR = new RowPanelTwoItems[]{
    };
    public static final RowPanelTwoItems<?, ?>[] QUERY_FIVE = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("Accounts with transactions exceeding X in the last month"), new TextField()),
    };
    public static final RowPanelTwoItems<?, ?>[] QUERY_SIX = new RowPanelTwoItems[]{
    };
    public static final RowPanelTwoItems<?, ?>[] QUERY_SEVEN = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("Customers who have taken out loans larger than X"), new TextField()),
    };
    public static final RowPanelTwoItems<?, ?>[] QUERY_EIGHT = new RowPanelTwoItems[]{
    };
    public static final RowPanelTwoItems<?, ?>[] QUERY_NINE = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("Total transaction amount per day for the last X days."), new TextField()),
    };
    public static final RowPanelTwoItems<?, ?>[] QUERY_TEN = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("Top X highest transactions made in the past year."), new TextField()),
    };
    public static final RowPanelTwoItems<?, ?>[] QUERY_ELEVEN = new RowPanelTwoItems[]{
    };
    public static final RowPanelTwoItems<?, ?>[] QUERY_TWELVE = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("All credit cards expiring within the next X months"), new TextField()),

    };
    public static final RowPanelTwoItems<?, ?>[] QUERY_THIRTEEN = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("Customers who have credit card limits exceeding X"), new TextField()),
    };
    public static final RowPanelTwoItems<?, ?>[] QUERY_FOURTEEN = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("ATMs that processed more than X in the last month"), new TextField()),
    };
    public static final RowPanelTwoItems<?, ?>[] QUERY_FIFTEEN = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("ATMs with no transactions in the last X months"), new TextField()),
    };
    public static final RowPanelTwoItems<?, ?>[] QUERY_SIXTEEN = new RowPanelTwoItems[]{
    };
    public static final RowPanelTwoItems<?, ?>[] QUERY_SEVENTEEN = new RowPanelTwoItems[]{
    };
    public static final RowPanelTwoItems<?, ?>[] QUERY_EIGHTEEN = new RowPanelTwoItems[]{
    };
    public static final RowPanelTwoItems<?, ?>[] QUERY_NINETEEN = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("Branches with a total balance across accounts exceeding X"), new TextField()),

    };


}

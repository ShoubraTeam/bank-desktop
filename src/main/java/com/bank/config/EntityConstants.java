package com.bank.config;

import com.bank.ui.*;
import com.bank.views.forms.RowPanelOneItem;
import com.bank.views.forms.RowPanelThreeItems;
import com.bank.views.forms.RowPanelTwoItems;

import javax.swing.*;
import java.awt.Component;

public class EntityConstants {

    public static final String[] CheckBoxesModifyConstants = {"Where", "Modify"};

    /*
        ATM Constants
     */

    public static final String[] ATM_TYPES = {"Single", "Double"};
    public static final RowPanelTwoItems<?, ?>[] ATM_ADD_ATTRIBUTES = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("Location"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Balance"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Capacity"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("ATM Type"), new ComboBox(ATM_TYPES)),
    };
    public static final RowPanelThreeItems<?, ?,?>[] ATM_MODIFY_ATTRIBUTES = new RowPanelThreeItems[]{
            new RowPanelThreeItems<Label, Component, Component>(new Label("ATM ID"), new TextField(), new RowPanelOneItem(new RadioButton(CheckBoxesModifyConstants[0]))),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Location"), new TextField(), new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Balance"), new TextField(), new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Capacity"), new TextField(), new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
            new RowPanelThreeItems<Label, Component, Component>(new Label("ATM Type"), new ComboBox(ATM_TYPES), new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
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
    public static final RowPanelThreeItems<?, ?,?>[] CUSTOMER_MODIFY_ATTRIBUTES = new RowPanelThreeItems[]{

            new RowPanelThreeItems<Label, Component, Component>(new Label("National ID"), new TextField(), new RowPanelOneItem(new RadioButton(CheckBoxesModifyConstants[0]))),
            new RowPanelThreeItems<Label, Component, Component>(new Label("First Name"), new TextField(), new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Last Name"), new TextField(), new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Address"), new TextField(), new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Email"), new TextField(), new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Phone Number"), new TextField(), new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Dead"), new JCheckBox(), new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
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
    public static final RowPanelThreeItems<?, ?,?>[] BRANCH_MODIFY_ATTRIBUTES = new RowPanelThreeItems[]{
            new RowPanelThreeItems<Label, Component, Component>(new Label("Branch ID"), new TextField(), new RowPanelOneItem(new RadioButton(CheckBoxesModifyConstants[0]))),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Location"), new TextField(), new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Phone Number"), new TextField(), new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Branch Type"), new ComboBox(BRANCH_TYPE), new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
    };


    /*
        Transaction Constants
     */
    public static final String[] TRANSACTION_TYPE = {"WITHDRAW", "DEPOSIT"};
    public static final RowPanelTwoItems<?, ?>[] TRANSACTION_ADD_ATTRIBUTES = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("Amount"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Description"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Transaction Type"), new ComboBox(TRANSACTION_TYPE)),
    };
    public static final RowPanelThreeItems<?, ?,?>[] TRANSACTION_MODIFY_ATTRIBUTES = new RowPanelThreeItems[]{
            new RowPanelThreeItems<Label, Component, Component>(new Label("Transaction ID"), new TextField(), new RowPanelOneItem(new RadioButton(CheckBoxesModifyConstants[0]))),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Amount"), new TextField(), new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Description"), new TextField(), new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Transaction Type"), new ComboBox(TRANSACTION_TYPE), new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
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
    public static final RowPanelThreeItems<?, ?,?>[] CREDIT_CARD_MODIFY_ATTRIBUTES = new RowPanelThreeItems[]{
            new RowPanelThreeItems<Label, Component,Component>(new Label("Card Number"), new TextField(), new RowPanelOneItem(new RadioButton(CheckBoxesModifyConstants[0]))),
            new RowPanelThreeItems<Label, Component,Component>(new Label("Balance"), new TextField(), new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
            new RowPanelThreeItems<Label, Component,Component>(new Label("CVC"), new TextField(), new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
            new RowPanelThreeItems<Label, Component,Component>(new Label("PIN"), new TextField(), new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
            new RowPanelThreeItems<Label, Component,Component>(new Label("Expiration date"), new TextField(), new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
            // TODO: adjust value for expiration date: modified date + 7 years
            new RowPanelThreeItems<Label, Component,Component>(new Label("Card Type"), new ComboBox(CARD_TYPE), new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
    };

    /*
        Transfers Constants
    */
    public static final RowPanelTwoItems<?, ?>[] TRANSFER_ADD_ATTRIBUTES = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("Amount"), new TextField()),
    };

    public static final RowPanelThreeItems<?, ?,?>[] TRANSFER_MODIFY_ATTRIBUTES = new RowPanelThreeItems[]{
            new RowPanelThreeItems<Label, Component, Component>(new Label("Branch ID"), new TextField(), new RowPanelOneItem(new RadioButton(CheckBoxesModifyConstants[0]))),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Sender ID"), new TextField(), new RowPanelOneItem(new RadioButton(CheckBoxesModifyConstants[0]))),
            new RowPanelThreeItems<Label, Component, Component>(new Label("Receiver ID"), new TextField(), new RowPanelOneItem(new RadioButton(CheckBoxesModifyConstants[0]))),
            new RowPanelThreeItems<Label, Component,Component>(new Label("Amount"), new TextField(), new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
    };

    /*
        Bank Account Constants
    */
    public static final String[] ACCOUNT_TYPE = {"Savings", "Checking"};
    public static final RowPanelTwoItems<?, ?>[] BANK_ACCOUNT_ADD_ATTRIBUTES = new RowPanelTwoItems[]{
            new RowPanelTwoItems<Label, Component>(new Label("Balance"), new TextField()),
            new RowPanelTwoItems<Label, Component>(new Label("Account Type"), new ComboBox(ACCOUNT_TYPE)),
    };

    public static final RowPanelThreeItems<?, ?,?>[] BANK_ACCOUNT_MODIFY_ATTRIBUTES = new RowPanelThreeItems[]{
            new RowPanelThreeItems<Label, Component, Component>(new Label("Account ID"), new TextField(), new RowPanelOneItem(new RadioButton(CheckBoxesModifyConstants[0]))),
            new RowPanelThreeItems<Label, Component,Component>(new Label("Balance"), new TextField(),new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
            new RowPanelThreeItems<Label, Component,Component>(new Label("Account Type"), new ComboBox(ACCOUNT_TYPE),new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
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
            new RowPanelTwoItems<Label, Component>(new Label("Settled"), new JCheckBox()),
    };
    public static final RowPanelThreeItems<?, ?,?>[] LOAN_MODIFY_ATTRIBUTES = new RowPanelThreeItems[]{
            new RowPanelThreeItems<Label, Component, Component>(new Label("Loan ID"), new TextField(), new RowPanelOneItem(new RadioButton(CheckBoxesModifyConstants[0]))),
            new RowPanelThreeItems<Label, Component,Component>(new Label("Amount"), new TextField(),new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
            new RowPanelThreeItems<Label, Component,Component>(new Label("Reason"), new TextField(),new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
            new RowPanelThreeItems<Label, Component,Component>(new Label("Assurance"), new TextField(),new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
            new RowPanelThreeItems<Label, Component,Component>(new Label("Number of months"), new ComboBox(LOAN_NUMBER_OF_MONTHS),new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
            new RowPanelThreeItems<Label, Component,Component>(new Label("Settled"), new JCheckBox(),new CheckBoxPanel(new RadioButton(CheckBoxesModifyConstants[0]), new RadioButton(CheckBoxesModifyConstants[1]))),
    };
}

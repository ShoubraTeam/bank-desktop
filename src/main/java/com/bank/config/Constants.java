package com.bank.config;

import com.bank.views.*;
import com.bank.views.dynamicform.DynamicFormOption;
import com.bank.views.forms.add.*;

import com.bank.views.forms.modify.*;


import com.bank.views.forms.delete.*;
import com.bank.views.forms.queries.*;


import com.bank.views.tabs.Tab;

/**
 * A utility class that defines constant values used throughout the application.
 * <p>
 * This class contains static constants such as predefined tabs.
 * </p>
 */
public class Constants {
    public static final DynamicFormOption[] ADD_ENTITY_OPTIONS = {
            new DynamicFormOption("ATM", new AddATMForm()),
            new DynamicFormOption("Branch", new AddBranchForm()),
            new DynamicFormOption("Customer", new AddCustomerForm()),
            new DynamicFormOption("Transaction", new AddTransactionForm()),
            new DynamicFormOption("Credit Card", new AddCreditCardForm()),
            new DynamicFormOption("Transfers", new AddTransfersForm()),
            new DynamicFormOption("Bank Account", new AddBankAccountForm()),
            new DynamicFormOption("Loan", new AddLoanForm()),
    };
    public static final DynamicFormOption[] MODIFY_ENTITY_OPTIONS = {
            new DynamicFormOption("ATM", new ModifyATMFrom()),
            new DynamicFormOption("Branch", new ModifyBranchForm()),
            new DynamicFormOption("Customer", new ModifyCustomerForm()),
            new DynamicFormOption("Transaction", new ModifyTransactionForm()),
            new DynamicFormOption("Credit Card", new ModifyCreditCardForm()),
            new DynamicFormOption("Transfers", new ModifyTransfersForm()),
            new DynamicFormOption("Bank Account", new ModifyBankAccountForm()),
            new DynamicFormOption("Loan", new ModifyLoanForm()),
    };

    public static final DynamicFormOption[] DELETE_ENTITY_OPTIONS = {
            new DynamicFormOption("ATM", new DeleteATMForm()),
            new DynamicFormOption("Branch", new DeleteBranchForm()),
            new DynamicFormOption("Customer", new DeleteCustomerForm()),
            new DynamicFormOption("Transaction", new DeleteTransactionForm()),
            new DynamicFormOption("Credit Card", new DeleteCreditCardForm()),
            new DynamicFormOption("Transfers", new DeleteTransfersForm()),
            new DynamicFormOption("Bank Account", new DeleteBankAccountForm()),
            new DynamicFormOption("Loan", new DeleteLoanForm()),
    };

    public static final DynamicFormOption[] QUERIES_OPTIONS = {
            new DynamicFormOption("List all customers who joined in the last X days.", new Query1View()),
            new DynamicFormOption("List customers who do not have any associated bank accounts.", new Query2View()),
            new DynamicFormOption("List accounts with a balance below the average balance.", new Query3View()),
            new DynamicFormOption("Find the total balance of all accounts.", new Query4View()),
            new DynamicFormOption("List accounts with transactions exceeding X in the last month.", new Query5View()),
            new DynamicFormOption("Find the total balance of all bank accounts related to a specific customer.", new Query6View()),
            new DynamicFormOption("Find customers who have taken out loans larger than X.", new Query7View()),
            new DynamicFormOption("List the total loan amounts issued by each branch.", new Query8View()),
            new DynamicFormOption("Find the total transaction amount per day for the last X days.", new Query9View()),
            new DynamicFormOption("List the top X highest transactions made in the last week.", new Query10View()),
            new DynamicFormOption("Find the total transaction amount by each customer in the last month.", new Query11View()),
            new DynamicFormOption("Retrieve all credit cards expiring within the next X months.", new Query12View()),
            new DynamicFormOption("Find customers who have credit card balance exceeding X.", new Query13View()),
            new DynamicFormOption("List ATMs that processed more than X in the last month.", new Query14View()),
            new DynamicFormOption("Retrieve ATMs with no transactions in the last X months.", new Query15View()),
            new DynamicFormOption("Find the average transaction amount for each ATM.", new Query16View()),
            new DynamicFormOption("Find the branch with the highest number of bank accounts.", new Query17View()),
            new DynamicFormOption("Retrieve branches that issued loans in the last month.", new Query18View()),
            new DynamicFormOption("List branches with a total balance across accounts exceeding X.", new Query19View()),
    };

    /**
     * An array of {@link Tab} objects representing the available tabs in the
     * application's navigation panel. Each tab is associated with a label,
     * a unique {@link String} key, and a corresponding <code>JPanel</code> that
     * represents the content for that tab.
     */
    public static final Tab[] TABS = {
            new Tab("View Entity", "ViewEntity", new ViewEntityPanel()),
            new Tab("Add Entity", "AddEntity", new AddEntityPanel()),
            new Tab("Modify Entity", "ModifyEntity", new ModifyEntityPanel()),
            new Tab("Delete Entity", "DeleteEntity", new DeleteEntityPanel()),
            new Tab("Queries", "Queries", new QueriesEntityPanel()),
    };
}

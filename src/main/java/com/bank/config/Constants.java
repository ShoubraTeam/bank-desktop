package com.bank.config;

import com.bank.views.*;
import com.bank.views.dynamicform.DynamicFormOption;
import com.bank.views.forms.add.*;
import com.bank.views.forms.delete.DeleteATMForm;
import com.bank.views.forms.delete.DeleteBranchForm;
import com.bank.views.forms.modify.*;
import com.bank.views.forms.queries.Query1View;
import com.bank.views.forms.queries.Query2View;
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
    };

    public static final DynamicFormOption[] QUERIES_OPTIONS = {
            new DynamicFormOption("Query 1", new Query1View()),
            new DynamicFormOption("Query 2", new Query2View()),
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

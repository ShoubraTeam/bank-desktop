package com.bank.config;

import com.bank.ui.ComboBox;
import com.bank.ui.Label;
import com.bank.ui.TextField;
import com.bank.views.AddEntityPanel;
import com.bank.views.ViewEntityPanel;
import com.bank.views.addPanel.RawPanelTwoItems;
import com.bank.views.tabs.Tab;

import java.awt.*;

public class ATMconstats {
    public static final String[] ATM_TYPES={"Single","Double"};
    public static final RawPanelTwoItems<Label, Component> []Attributes = new RawPanelTwoItems[]{
            new RawPanelTwoItems<Label, Component>(new Label("Location"), new TextField()),
            new RawPanelTwoItems<Label, Component>(new Label("Balance"), new TextField()),
            new RawPanelTwoItems<Label, Component>(new Label("ATM Types"), new ComboBox(ATM_TYPES)),
    };

}

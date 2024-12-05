package com.bank.config;

import com.bank.ui.Tab;
import com.bank.views.AddEntityPanel;
import com.bank.views.ViewEntityPanel;

public class Constants {
    public static final Tab[] tabs = {
            new Tab("View Entity", TabKey.VIEW_ENTITY, new ViewEntityPanel()),
            new Tab("Add Entity", TabKey.ADD_ENTITY, new AddEntityPanel()),
    };
}

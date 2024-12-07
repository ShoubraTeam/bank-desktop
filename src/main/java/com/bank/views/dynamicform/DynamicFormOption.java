package com.bank.views.dynamicform;

import java.awt.*;

public class DynamicFormOption {
    private String name;
    private Component view;

    public DynamicFormOption(String name, Component view) {
        this.name = name;
        this.view = view;
    }

    public String getName() {
        return name;
    }

    public Component getView() {
        return this.view;
    }
}

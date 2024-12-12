package com.bank.utils;

import java.util.HashMap;

public class HashMapPair {
    HashMap<String,String> list1;
    HashMap<String,String> list2;

    // Constructor
    public HashMapPair(HashMap<String,String> list1, HashMap<String,String> list2) {
        this.list1 = list1;
        this.list2 = list2;
    }

    public HashMap<String,String> getFirstList() {
        return list1;
    }

    public HashMap<String,String> getSecondList() {
        return list2;
    }
}

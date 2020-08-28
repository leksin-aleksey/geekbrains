package com.geekbrains.java.course.custom;

import java.util.*;

public class YellowPages {
    private Map<String, ArrayList<String>> map = new HashMap<>();

    public void add(String name, String phone) {
        ArrayList<String> phones = map.get(name);

        if(phones == null){
            phones = new ArrayList<>(Arrays.asList(phone));
        }
        else{
            phones.add(phone);
        }

        map.put(name, phones);
    }

    public ArrayList<String> get(String name) {
        return map.get(name);
    }
}

package com.geekbrains.java.course.custom;

import java.util.*;

public class YellowPages {
    private Map<String, HashSet<String>> map = new HashMap<>();

    public void add(String name, String phone) {
        HashSet<String> phones = map.get(name);

        if(phones == null){
            phones = new HashSet<>(Arrays.asList(phone));
        }
        else{
            phones.add(phone);
        }

        map.put(name, phones);
    }

    public HashSet<String> get(String name) {
        return map.get(name);
    }
}

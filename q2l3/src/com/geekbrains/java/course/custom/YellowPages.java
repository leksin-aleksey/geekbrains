package com.geekbrains.java.course.custom;

import java.util.*;

public class YellowPages {
    private Map<String, HashSet<PhoneNumber>> map = new HashMap<>();

    public void add(String name, PhoneNumber phone) {
        HashSet<PhoneNumber> phones = map.get(name);

        if(phones == null){
            phones = new HashSet<>(Arrays.asList(phone));
        }
        else{
            phones.add(phone);
        }

        map.put(name, phones);
    }

    public HashSet<PhoneNumber> get(String name) {
        return map.get(name);
    }
}

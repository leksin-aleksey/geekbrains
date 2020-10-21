package ru.geekbrains.java.api.test;

import ru.geekbrains.java.api.test.AfterSuite;
import ru.geekbrains.java.api.test.BeforeSuite;

public enum Suits {

    BEFORE_SUITE(BeforeSuite.class), AFTER_SUITE(AfterSuite.class);

//    private Class<?> clazz;

    Suits(Class<?> clazz){
//        this.clazz = clazz;
    }

//    public ru.geekbrains.java.api.test.Suits valueOf(Class<?> clazz){
//
//    }
}

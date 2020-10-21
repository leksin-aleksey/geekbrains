package ru.geekbrains.java.tests;

import ru.geekbrains.java.api.test.BeforeSuite;
import ru.geekbrains.java.api.test.AfterSuite;
import ru.geekbrains.java.api.test.Test;

public class CustomTest1 {
    public CustomTest1(){}

    @BeforeSuite
    public void doFirst(String s){
        System.out.println("prepare");
    }

    @Test
    public void doTest1(){
        System.out.println("test1");
    }

    @Test
    public void doTest2(){
        System.out.println("test2");
    }

    @AfterSuite
    public void doLast(String s){
        System.out.println("finish");
    }
}

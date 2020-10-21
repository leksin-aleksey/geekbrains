package ru.geekbrains.java.tests;

import ru.geekbrains.java.api.test.BeforeSuite;
import ru.geekbrains.java.api.test.AfterSuite;
import ru.geekbrains.java.api.test.Test;

public class CustomTest1 {
    public CustomTest1(){}

    @BeforeSuite
    public void doFirst(){
        System.out.println("do prepare");
    }

    @Test(order = 5)
    public void doTest1(){
        System.out.println("do test1");
    }

    @Test
    public void doTest2(){
        System.out.println("do test2");
    }

    @Test(order = 10)
    public void doTest3(){
        System.out.println("do test3");
    }

    @Test(order = 5)
    public void doTest4(){
        System.out.println("do test4");
    }

    @AfterSuite
    public void doLast(){
        System.out.println("do finish");
    }
}

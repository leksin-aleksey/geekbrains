package ru.geekbrains.java.tests;

import ru.geekbrains.java.api.test.BeforeSuite;
import ru.geekbrains.java.api.test.AfterSuite;
import ru.geekbrains.java.api.test.Test;

public class CustomTest1 {
    @BeforeSuite
    public void doFirst(){

    }

    @Test
    public void doTest1(){

    }

    @Test
    public void doTest2(){

    }

    @AfterSuite
    public void diLast(){

    }
}

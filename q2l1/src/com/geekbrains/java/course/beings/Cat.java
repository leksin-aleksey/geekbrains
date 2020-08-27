package com.geekbrains.java.course.beings;

import com.geekbrains.java.course.actions.Jumpable;
import com.geekbrains.java.course.actions.Runnable;

public class Cat extends Animal {

    public Cat(String name, int maxLength, int maxHeight) {
        super(name, maxLength, maxHeight);
    }

    @Override
    public void run() {
        System.out.printf("%s is running%n", super.getName());
    }

    @Override
    public void jump() {
        System.out.printf("%s is jumping%n", super.getName());
    }
}

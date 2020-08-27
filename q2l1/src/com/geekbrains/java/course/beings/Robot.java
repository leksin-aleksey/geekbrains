package com.geekbrains.java.course.beings;

import com.geekbrains.java.course.actions.Jumpable;
import com.geekbrains.java.course.actions.Runnable;

public class Robot extends Being implements Runnable, Jumpable {

    public Robot(String name, int maxLength, int maxHeight) {
        super(name, maxLength, maxHeight);
    }

    @Override
    public void run() {
        System.out.printf("%s is running%n", name);
    }

    @Override
    public void jump() {
        System.out.printf("%s is jumping%n", name);
    }
}

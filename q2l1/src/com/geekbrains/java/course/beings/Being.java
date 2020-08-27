package com.geekbrains.java.course.beings;

import com.geekbrains.java.course.actions.Jumpable;
import com.geekbrains.java.course.actions.Runnable;

public abstract class Being implements Runnable, Jumpable {
    private final String name;
    private final int maxLength, maxHeight;

    public Being(String name, int maxLength, int maxHeight) {
        this.name = name;
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
    }

    protected String getName() {
        return name;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public int getMaxHeight() {
        return maxHeight;
    }
}

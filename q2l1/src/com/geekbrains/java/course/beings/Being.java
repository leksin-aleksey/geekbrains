package com.geekbrains.java.course.beings;

public abstract class Being {
    protected String name;
    private int maxLength, maxHeight;

    public Being(String name, int maxLength, int maxHeight) {
        this.name = name;
        this.maxLength = maxLength;
        this.maxHeight = maxHeight;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public int getMaxHeight() {
        return maxHeight;
    }
}

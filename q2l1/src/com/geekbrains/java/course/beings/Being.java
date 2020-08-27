package com.geekbrains.java.course.beings;

public abstract class Being {
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

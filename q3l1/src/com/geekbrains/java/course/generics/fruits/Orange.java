package com.geekbrains.java.course.generics.fruits;

public class Orange extends Fruit{
    private static final float weight = 1.5f;

    public Orange() {
    }

    @Override
    public float getWeight() {
        return weight;
    }
}

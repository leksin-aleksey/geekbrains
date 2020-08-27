package com.geekbrains.java.course.hurdles;

import com.geekbrains.java.course.actions.Runnable;
import com.geekbrains.java.course.beings.Being;

public class Treadmill implements Hurdle {
    private final int length;

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public boolean doAction(Being being){
        Runnable beingRunnable = (Runnable) being;
        beingRunnable.run();
        return beingRunnable.getMaxLength() >= length;
    }
}

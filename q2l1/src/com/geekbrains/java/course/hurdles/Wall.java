package com.geekbrains.java.course.hurdles;

import com.geekbrains.java.course.actions.Jumpable;
import com.geekbrains.java.course.beings.Being;

public class Wall implements Hurdle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean doAction(Being being){
        Jumpable beingJumpable = (Jumpable) being;
        beingJumpable.jump();
        return beingJumpable.getMaxHeight() >= height;
    }
}

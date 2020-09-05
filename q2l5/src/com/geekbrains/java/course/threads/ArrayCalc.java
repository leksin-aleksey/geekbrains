package com.geekbrains.java.course.threads;

import com.geekbrains.java.course.utils.ArrayInit;

public class ArrayCalc implements Runnable {
    private float[] arr;
    private int part;

    public ArrayCalc(int part) {
        this.part = part;
        arr = ArrayInit.getArray(part);
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            int addedIndex = (part == 1 ? ArrayInit.h : 0);
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (i + addedIndex) / 5) * Math.cos(0.2f + (i + addedIndex) / 5) * Math.cos(0.4f + (i + addedIndex) / 2));
        }
        if(part != -1){
            ArrayInit.arrParallelCalc(arr, part);
        }
    }
}

package com.geekbrains.java.course.threads;

import com.geekbrains.java.course.utils.ArrayInit;
import com.geekbrains.java.course.utils.CalcTypes;

public class ArrayCalc implements Runnable {
    private float[] arr;
    private CalcTypes type;

    public ArrayCalc(CalcTypes type) {
        this.type = type;
        arr = ArrayInit.getArray(type);
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            int addedIndex = (type == CalcTypes.PARALLEL2 ? ArrayInit.h : 0);
            arr[i] = (float)(arr[i] * Math.sin(0.2f + (i + addedIndex) / 5) * Math.cos(0.2f + (i + addedIndex) / 5) * Math.cos(0.4f + (i + addedIndex) / 2));
        }
        ArrayInit.arrParallelCalc(arr, type);
    }
}

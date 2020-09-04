package com.geekbrains.java.course.utils;

import java.util.Arrays;

public class ArrayInit {
    static final int size = 10000000;
    static final int h = size / 2;
    final float[] arr = new float[size];
    float[] arrPart = new float[h];

    public ArrayInit(){
        for (int i = 0; i < size; i++) {
            arr[i] = 1f;
        }
    }

    public float[] getArray(){
        return Arrays.copyOf(arr, size);
    }

    public float[] getArrayPart(int part){
        switch (part){
            case 0:
                System.arraycopy(arr, 0, arrPart, 0, h);
                break;
            case 1:
                System.arraycopy(arr, h, arrPart, 0, h);
                break;
        }
        return arrPart;
    }
}

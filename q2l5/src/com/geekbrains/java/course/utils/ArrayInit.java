package com.geekbrains.java.course.utils;

import java.util.Arrays;

public class ArrayInit {
    private static final int size = 10000000;
    public static final int h = size / 2;
    private static final float[] arr = new float[size];
    private static float[] arrParallel = new float[size];

    static {
        for (int i = 0; i < size; i++) {
            arr[i] = 1f;
        }
    }

    static public float[] getArray(int part){
        float[] arrPart;
        switch (part){
            case -1:
                return Arrays.copyOf(arr, size);
            case 0:
                arrPart = new float[h];
                System.arraycopy(arr, 0, arrPart, 0, h);
                return arrPart;
            case 1:
                arrPart = new float[h];
                System.arraycopy(arr, h, arrPart, 0, h);
                return arrPart;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static synchronized void arrParallelCalc(float[] a, int part){
        switch (part){
            case 0:
                System.arraycopy(a, 0, arrParallel, 0, h);
                break;
            case 1:
                System.arraycopy(a, 0, arrParallel, h, h);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}

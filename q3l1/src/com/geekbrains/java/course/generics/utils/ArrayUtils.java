package com.geekbrains.java.course.generics.utils;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayUtils {
    public static <T> T[] swapElements(T[] arr, int i, int j) throws IndexOutOfBoundsException{
        T temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;

        return arr;
    }

    public static <T> ArrayList<T> toArrayList(T[] arr){
        return new ArrayList<>(Arrays.asList(arr));
    }
}

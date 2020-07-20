package com.geekbrains.java.course;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    //1
        createAndChange();

        //2
        createAndFill();

        //3
        createAndMultiplyCond();

        //4
        createUnitMatrix();

        //5
        lookupMinMax();

        //6
        int[] array6 = {-7, 3 ,4, 1, 1, 1, 2, 6};
        checkBalance(array6);

        //7
        int[] array7 = {1, 2, 3, 4, 5, 6};
        int n = 3;
        int[] array7Result = moveElements(array7, n);
    }

    private static void createAndChange(){
        byte array1[] = {0, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for(int i = 0; i < array1.length; i++){
            array1[i] = (array1[i] == 0 ? (byte)1 : 0);
        }
    }

    private static void createAndFill(){
        int[] array2 = new int[8];
        for(int i = 0; i < array2.length; i++){
            array2[i] = i * 3;
        }
    }

    private static void createAndMultiplyCond(){
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for(int i = 0; i < array3.length; i++){
            if(array3[i] < 6) array3[i] *= 2;
        }
    }

    private static void createUnitMatrix(){
        byte[][] array4 = new byte[10][10];
        for(byte i = 0; i < 10; i++){
            array4[i][i] = 1;
        }
        for (byte[] x : array4) {for (byte y : x) {System.out.print(y + " ");}System.out.println();}
    }

    private static int[] lookupMinMax(){
        int[] array5 = {2, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int min, max;
        min = max = array5[0];
        for(int i = 1; i < array5.length; i++){
            if(min > array5[i]) min = array5[i];
            if(max < array5[i]) max = array5[i];
        }
        System.out.println(min + ", " + max);
        return new int[]{min, max};
    }

    private static boolean checkBalance(int[] array6){
        if(array6.length == 0 || array6.length == 1) return false;

        int pos = array6.length / 2;
        int sumLeft, sumRight;
        sumLeft = sumRight = 0;
        for(int i = 0; i < array6.length; i++){
            if(i < pos) sumLeft += array6[i];
            else sumRight += array6[i];
        }

        boolean sumChanged = sumLeft > sumRight;
        while(sumLeft != sumRight) {
            if(sumChanged != sumLeft > sumRight) return false;
            if (sumLeft > sumRight) {
                if (--pos == 0) return false;
                sumLeft -= array6[pos];
                sumRight += array6[pos];
            } else {
                if (++pos == array6.length) return false;
                sumLeft += array6[pos - 1];
                sumRight -= array6[pos - 1];
            }
        }
        return true;
    }

    private static int[] moveElements(int[] array7, int n){

        int len = array7.length;
        int diff = n % len;

        if(diff == 0) return array7;

        int iterNum;
        if(len % Math.abs(diff) != 0) iterNum = 1;
        else iterNum = Math.abs(diff);

        int valueTemp;
        for(int iter = 0; iter < iterNum; iter++){
            int indx = (iter + diff + len) % len;
            int valuePrev = array7[iter];
            do{
                valueTemp = array7[indx];
                array7[indx] = valuePrev;
                valuePrev = valueTemp;
                indx = (indx + diff + len) % len;
            }
            while(indx != (iter + diff + len) % len);
        }
        return array7;
    }
}

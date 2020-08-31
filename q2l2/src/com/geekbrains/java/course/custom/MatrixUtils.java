package com.geekbrains.java.course.custom;

import com.geekbrains.java.course.custom.exceptions.MyArrayDataException;
import com.geekbrains.java.course.custom.exceptions.MyArraySizeException;

public class MatrixUtils {

    public static int sumMatrix(String[][] matrix) throws MyArraySizeException, MyArrayDataException {
        int result = 0;

        if(matrix.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    result += Integer.parseInt(matrix[i][j]);
                }
                catch (NumberFormatException nfe){
                    throw new MyArrayDataException(
                            String.format("[%s][%s]: \"%s\"", i, j, matrix[i][j]),
                            nfe.getCause());
                }
            }
        }
        return result;
    }
}

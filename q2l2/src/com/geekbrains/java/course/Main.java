package com.geekbrains.java.course;

import com.geekbrains.java.course.custom.exceptions.MyArrayDataException;
import com.geekbrains.java.course.custom.exceptions.MyArraySizeException;

public class Main {

    public static void main(String[] args) {
	    String[][] matrix = new String[][]{
                {"0", "1", "5", "2"},
                {"10", "0", "45", "2"},
                {"3", "5", "3", "6"},
                {"1", "-100", "5", "23"}
        };

	    try {
            System.out.println(sumMatrix(matrix));
        }
        catch (MyArraySizeException mase) {
            System.out.println("Wrong 2d array size");
        }
	    catch (MyArrayDataException made){
            System.out.printf("Unparsable value at %s%n", made.getMessage());
        }
    }

    private static int sumMatrix(String[][] matrix) throws MyArraySizeException, MyArrayDataException{
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
                            String.format("[%s][%s]: \"%s\"", i, j, matrix[i][j]));
                }
            }
        }
        return result;
    }
}

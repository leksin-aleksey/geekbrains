package com.geekbrains.java.course;

import com.geekbrains.java.course.custom.MatrixUtils;
import com.geekbrains.java.course.custom.exceptions.MyArrayDataException;
import com.geekbrains.java.course.custom.exceptions.MyArraySizeException;

public class Main {

    public static void main(String[] args) {
	    String[][] matrix = new String[][]{
                {"0", "1", "5", "2i"},
                {"10", "0", "45", "2"},
                {"3", "5", "3", "6"},
                {"1", "-100", "5", "23"}
        };

	    try {
            System.out.println(MatrixUtils.sumMatrix(matrix));
        }
        catch (MyArraySizeException mase) {
            System.out.println("Wrong 2d array size");
        }
	    catch (MyArrayDataException made){
            System.out.printf("Unparsable value at %s%n", made.getMessage());
        }
    }
}

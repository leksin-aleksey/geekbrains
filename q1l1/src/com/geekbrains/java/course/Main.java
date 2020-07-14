package com.geekbrains.java.course;

public class Main {

    //1
    public static void main(String[] args) {
        //2
        byte b = 1;
        short s = -30000;
        int i = 100000;
        long l;

        float f = 234.45f;
        double d = 2.45e3d;

        boolean fl = true;

        char ch = 'A';

        //3
        System.out.println(doCalc(-3, 2, 100.2f, 3f));

        //4
        System.out.println(checkSum(14, 6));

        //5
        System.out.println(checkNumberSign(-3));

        //6
        System.out.println(checkNumberNegative(-43));

        //7
        printGreeting("Макс");

        //8
        isLeap(2300);
    }

    private static float doCalc(int a, int b, float c, float d) {
        return a * (b + (c / d));
    }

    private static boolean checkSum(int a, int b){
        return a + b >= 10 && a + b <= 20;
    }

    private static String checkNumberSign(int s){
        return s > 0 ? "Positive" : "Negative";
    }

    private static boolean checkNumberNegative(int s){
        return checkNumberSign(s).equals("Negative");
    }

    private static void printGreeting(String name){
        System.out.println("Привет, " + name + "!");
    }

    private static boolean isLeap(int year){

        boolean checkLeap = year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
        System.out.println("It's" + (checkLeap ? "" : " not") + " leap");
        return checkLeap;

    }
}

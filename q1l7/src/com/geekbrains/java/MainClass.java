package com.geekbrains.java;

public class MainClass {

    public static void main(String[] args){
        Cat[] cats = new Cat[5];

        Cat cat0 = new Cat("Barsik", 5);
        cats[0] = cat0;
        Cat cat1 = new Cat("Murzik", 4);
        cats[1] = cat1;
        Cat cat2 = new Cat("Tishka", 2);
        cats[2] = cat2;
        Cat cat3 = new Cat("Leopold", 1);
        cats[3] = cat3;
        Cat cat4 = new Cat("Tom", 5);
        cats[4] = cat4;


        Plate plate = new Plate(8);
//        plate.increaseFood(4);
        plate.info();

        //5
        for (Cat cat : cats){
            cat.eat(plate);
            cat.info();
        }

        plate.info();
    }

}

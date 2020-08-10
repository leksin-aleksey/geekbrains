package com.geekbrains.java;

public class Cat {
    private final String name;
    private final int appetite;
    //3
    private boolean notHungry;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p){
        try {
            p.decreaseFood(appetite);
            //3
            notHungry = true;
        }
        catch (InsufficientPlateResourcesException e){
            //4
            //Just keep notHungry
        }
    }

    public void info(){
        System.out.printf("%s is%s hungry%n", name, (notHungry ? " not" : ""));
    }
}

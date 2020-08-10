package com.geekbrains.java;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) throws InsufficientPlateResourcesException{
        if(food >= n){
            food -= n;
        }
        else {
            //2
            throw new InsufficientPlateResourcesException();
        }
    }

    //6
    public void increaseFood(int n){
        if(Integer.signum(n) == 1) {
            food += n;
        }
    }

    public void info(){
        System.out.println("plate: " + food);
    }
}

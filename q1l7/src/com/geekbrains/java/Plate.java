package com.geekbrains.java;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) throws InsufficientPlateResourcesException, NotPositiveFoodAmount{
        if(Integer.signum(n) != 1){
            throw new NotPositiveFoodAmount();
        }

        if(food >= n){
            food -= n;
        }
        else {
            //2
            throw new InsufficientPlateResourcesException();
        }
    }

    //6
    public void increaseFood(int n) throws NotPositiveFoodAmount{
        if(Integer.signum(n) == 1) {
            food += n;
        }
        else{
            throw new NotPositiveFoodAmount();
        }
    }

    public void info(){
        System.out.println("plate: " + food);
    }
}

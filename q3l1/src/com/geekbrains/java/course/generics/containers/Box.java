package com.geekbrains.java.course.generics.containers;

import com.geekbrains.java.course.generics.fruits.Fruit;

import java.util.ArrayList;

//b
public class Box<T extends Fruit> {
    //c
    private ArrayList<T> fruit;

    public Box() {
        fruit = new ArrayList<>();
    }

    public Box(ArrayList<T> fruit) {
        this.fruit = fruit;
    }

    public ArrayList<T> getFruit() {
        return fruit;
    }

    //g
    public boolean add(T... fruitElems){
        boolean result = true;
        for(T elem : fruitElems){
            if (!fruit.add(elem)){
                result = false;
            }
        }
        return result;
    }

    //f
    public boolean transfer(Box<T> box){
        if (this == box || box.getFruit() == null){
            return false;
        }

        boolean result = this.fruit.addAll(box.getFruit());
        box.clear();

        return result;
    }

    public void clear(){
        fruit.clear();
    }

    //d
    public float getWeight(){
        float boxWeight = 0f;
        for (T fruitElem : fruit){
            boxWeight += fruitElem.getWeight();
        }
        return boxWeight;
    }

    //e
    public boolean compare(Box<? extends Fruit> box){
        if (this == box){
            return true;
        }
        else {
            return getWeight() == box.getWeight();
        }
    }
}

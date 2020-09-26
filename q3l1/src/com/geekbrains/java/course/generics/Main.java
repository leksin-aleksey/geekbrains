/*
1. Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа);
2. Написать метод, который преобразует массив в ArrayList;
3. Большая задача:

a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
c. Для хранения фруктов внутри коробки можете использовать ArrayList;
d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той, которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае(коробки с яблоками мы можем сравнивать с коробками с апельсинами);
f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами), соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
g. Не забываем про метод добавления фрукта в коробку.

 */

package com.geekbrains.java.course.generics;


import com.geekbrains.java.course.generics.containers.Box;
import com.geekbrains.java.course.generics.fruits.Apple;
import com.geekbrains.java.course.generics.fruits.Orange;
import com.geekbrains.java.course.generics.utils.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //1
        System.out.println("1:");
        Integer[] array1 = new Integer[]{3, 5, 7, 8, 0};
        System.out.println(Arrays.toString(ArrayUtils.swapElements(array1, 0, 2)));

        //2
        System.out.println("\n2:");
        String[] array2  = new String[]{"one", "two", "three"};
        for (String str : ArrayUtils.toArrayList(array2)) {
            System.out.println(str);
        }

        //3
        System.out.println("\n3:");
        Box<Apple> appleBox1 = new Box<>();
        appleBox1.add(new Apple(), new Apple(), new Apple());

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.add(new Apple(), new Apple(), new Apple());

        Box<Apple> appleBox3 = new Box<>();
        appleBox3.add(new Apple());

        Box<Orange> orangeBox = new Box<>(
                new ArrayList<Orange>(){{
                    add(new Orange());
                    add(new Orange());
                }});

//        b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//        java compile error: incompatible types
//        orangeBox.add(new Apple());

        System.out.println(appleBox1.compare(appleBox2));
        System.out.println(appleBox1.compare(appleBox3));

        System.out.println(appleBox1.compare(orangeBox));

        appleBox1.transfer(appleBox2);
        System.out.println(appleBox1.getWeight());
        System.out.println(appleBox2.getWeight());

//        * помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами
//        java compile error: incompatible types
//        appleBox1.transfer(orangeBox);

        System.out.println(orangeBox.transfer(orangeBox));

        Box<Orange> orangeBox2 = new Box<>();
        Box<Orange> orangeBox3 = new Box<>();
        System.out.println(orangeBox2.compare(orangeBox3));
        System.out.println(orangeBox2.transfer(orangeBox3));
    }
}

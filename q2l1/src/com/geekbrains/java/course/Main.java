package com.geekbrains.java.course;

import com.geekbrains.java.course.beings.Being;
import com.geekbrains.java.course.beings.Cat;
import com.geekbrains.java.course.beings.Human;
import com.geekbrains.java.course.beings.Robot;
import com.geekbrains.java.course.hurdles.Hurdle;
import com.geekbrains.java.course.hurdles.Treadmill;
import com.geekbrains.java.course.hurdles.Wall;

public class Main {

    public static void main(String[] args) {
	    Being[] beings = new Being[] {
	            new Human("Human1", 10000, 190),
	            new Human("Human2",5500, 88),
                new Human("Human3",70, 21),
                new Cat("Cat1",560, 170),
                new Cat("Cat2",328, 140),
                new Cat("Cat3",200, 100),
                new Cat("Cat4",23, 23),
                new Cat("Cat5",0, 0),
                new Robot("Robot1",10000, 1000),
                new Robot("Robot2",1000, 100),
                new Robot("Robot3",100, 100)
        };

        Hurdle[] hurdles = new Hurdle[] {
                new Wall(170),
                new Treadmill(0),
                new Treadmill(80),
                new Wall(770),
                new Treadmill(8000),
                new Treadmill(18000),
                new Wall(1670)
        };

        for(Being being : beings){
            for(Hurdle hurdle : hurdles){
                if(!hurdle.doAction(being)){
                    break;
                }
            }
        }
    }
}

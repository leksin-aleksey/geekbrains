package com.geekbrains.java.course;

public class Main {

    public static void main(String[] args) {
        DoublyLinkedList<String> doubly = new DoublyLinkedList<>();
        doubly.add("Toyota");
        doubly.add("Honda");
        doubly.add("Nissan");
        doubly.add("Mazda");
        doubly.add("Suzuki");
        System.out.println(doubly);
    }
}

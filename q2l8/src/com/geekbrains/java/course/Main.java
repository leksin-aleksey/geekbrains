package com.geekbrains.java.course;

/*
*   2
* Реализовать двусвязный список.
* Двухсвязаный список - это такое список,
* который хранит специальном внутреннем контейнере значение и ссылки на предыдущий и следующий элементы.
* Важно отметить, что ссылка первого элемента на предыдущий всегда пустая,
* а для последнего - на следующий, поскольку в таких случая данным узлам не на что ссылаться
*
*
*   3
* ** Реализовать итератор для связаного списка.
*       Итератор - это механизм итерации по списку, который позволяет переключаться от одного элемента к другому,
*       пока не дойдет до конца, словно цикл. Важно отметить, что итератор предствляет собой экземпляр класса,
*       а значит может быть создан несколько раз, и в каждом случае старт будет начинаться с самого начала.
*   Важно: Нельзя прибегать в циклам.
*
*
*   4
* *** Итератор должен быть частью связаного списка,
*       но при этом с легкостью может быть использован для реализации в другом классе.
*       К примеру, итератор для ArrayList или HashSet.
*       Рекомендуется использовать интерфейсы с набором абстрактных методов и\или абстрактные классы
* */

public class Main {

    public static void main(String[] args) {
        DoublyLinkedList<String> doubly = new DoublyLinkedList<>();
        //2
        doubly.add("Toyota");
        doubly.add("Honda");
        doubly.add("Nissan");
        doubly.add("Mazda");
        doubly.add("Suzuki");

        //2
        doubly.remove("Toyota");
        doubly.remove("Toyota");
//        doubly.remove("Honda");
//        doubly.remove("Nissan");
//        doubly.remove("Mazda");
//        doubly.remove("Suzuki");

        System.out.println(doubly);

        //3-4
        System.out.println("iterator1:");
        GeekbrainsIterator<String> iterator1 = doubly.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        System.out.println("iterator2:");
        GeekbrainsIterator<String> iterator2 = doubly.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }

    }
}

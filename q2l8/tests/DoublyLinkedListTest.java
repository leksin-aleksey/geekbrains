import com.geekbrains.java.course.DoublyLinkedList;
import com.geekbrains.java.course.GeekbrainsIterator;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {

    private DoublyLinkedList<String> doubly;

    @org.junit.jupiter.api.Test
    void add() {
        doubly = new DoublyLinkedList<>();
        assertEquals("{null}", doubly.toString());

        doubly = new DoublyLinkedList<>();
        doubly.add("Toyota");
        assertEquals("{Toyota}", doubly.toString());

        doubly = new DoublyLinkedList<>();
        doubly.add("Toyota");
        doubly.add("Mazda");
        assertEquals("{Toyota, Mazda}", doubly.toString());

        doubly = new DoublyLinkedList<>();
        doubly.add("Toyota");
        doubly.add("Mazda");
        doubly.add("Honda");
        assertEquals("{Toyota, Mazda, Honda}", doubly.toString());
    }

    @org.junit.jupiter.api.Test
    void remove() {
        doubly = new DoublyLinkedList<>();
        doubly.add("Toyota");
        doubly.remove("Toyota");
        assertEquals("{null}", doubly.toString());

        doubly = new DoublyLinkedList<>();
        doubly.add("Toyota");
        doubly.add("Honda");
        doubly.remove("Toyota");
        assertEquals("{Honda}", doubly.toString());

        doubly = new DoublyLinkedList<>();
        doubly.add("Toyota");
        doubly.add("Honda");
        doubly.remove("Honda");
        assertEquals("{Toyota}", doubly.toString());

        doubly = new DoublyLinkedList<>();
        doubly.add("Toyota");
        doubly.add("Toyota");
        doubly.remove("Toyota");
        assertEquals("{Toyota}", doubly.toString());

        doubly = new DoublyLinkedList<>();
        doubly.add("Honda");
        doubly.add("Toyota");
        doubly.add("Toyota");
        doubly.remove("Toyota");
        assertEquals("{Honda, Toyota}", doubly.toString());

        doubly = new DoublyLinkedList<>();
        doubly.add("Toyota");
        doubly.add("Toyota");
        doubly.remove("Honda");
        assertEquals("{Toyota, Toyota}", doubly.toString());

        doubly = new DoublyLinkedList<>();
        doubly.remove("Honda");
        assertEquals("{null}", doubly.toString());
    }

    @org.junit.jupiter.api.Test
    void iterator() {
        GeekbrainsIterator<String> iterator;
        doubly = new DoublyLinkedList<>();
        String result = "";
        iterator = doubly.iterator();
        while (iterator.hasNext()){
            result = String.join(",", result, iterator.next());
        }
        assertEquals("", result);


        doubly = new DoublyLinkedList<>();
        doubly.add("Toyota");
        result = "";
        iterator = doubly.iterator();
        while (iterator.hasNext()){
            result = String.join(",", result, iterator.next());
        }
        assertEquals(",Toyota", result);


        doubly = new DoublyLinkedList<>();
        doubly.add("Toyota");
        doubly.add("Mazda");
        doubly.add("Toyota");
        result = "";
        iterator = doubly.iterator();
        while (iterator.hasNext()){
            result = String.join(",", result, iterator.next());
        }
        assertEquals(",Toyota,Mazda,Toyota", result);


        doubly = new DoublyLinkedList<>();
        doubly.add("Toyota");
        doubly.add("Mazda");
        doubly.add("Toyota");
        result = "";
        iterator = doubly.iterator();
        while (iterator.hasNext()){
            result = String.join(",", result, iterator.next());
        }
        assertEquals(",Toyota,Mazda,Toyota", result);
        iterator = doubly.iterator();
        while (iterator.hasNext()){
            result = String.join(",", result, iterator.next());
        }
        assertEquals(",Toyota,Mazda,Toyota,Toyota,Mazda,Toyota", result);
    }
}
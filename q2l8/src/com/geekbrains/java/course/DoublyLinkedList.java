package com.geekbrains.java.course;

public class DoublyLinkedList<T> implements GeekbrainsList<T>{

    private Node<T> head;

    public DoublyLinkedList() {

    }

    @Override
    public boolean add(T t) {
        try {
            head = add(t, head);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean remove(T t) {
        return true;
    }

    private Node<T> add(T t, Node<T> head){
        Node<T> current = head;
        if (current == null){
            current = new Node<>(null, null, t);
            return current;
        }
        else if (current.getNext() != null) {
            current = current.getNext();
            head.setNext(add(t, current));
            return head;
        }
        else {
            current.setNext(new Node<>(current, null, t));
            return head;
        }
    }


    @Override
    public String toString() {
        return "{" +
                toString(head) +
                '}';
    }

    private String toString(Node<T> node){
        if (node == null) {
            return null;
        } else if (node.getNext() == null){
            return node.getElem().toString();
        } else {
            return node.getElem().toString() + ", " + toString(node.getNext());
        }
    }

    private static class Node<T>{
        private Node<T> prev, next;

        private T t;

        public Node(Node<T> prev, Node<T> next, T t) {
            this.prev = prev;
            this.next = next;
            this.t = t;
        }

        public void setPrev(Node<T> prev) {
            this.prev = prev;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public Node<T> getPrev() {
            return prev;
        }

        public Node<T> getNext() {
            return next;
        }

        public T getElem() {
            return t;
        }
    }
}

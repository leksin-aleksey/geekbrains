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
        try {
            head = remove(t, head);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public GeekbrainsIterator<T> iterator() {
        return new DoublyIterator();
    }

    private Node<T> add(T t, Node<T> node){
        Node<T> current = node;
        if (current == null){
            current = new Node<>(null, null, t);
            return current;
        }
        else if (current.getNext() != null) {
            current = current.getNext();
            node.setNext(add(t, current));
            return node;
        }
        else {
            current.setNext(new Node<>(current, null, t));
            return node;
        }
    }

    private Node<T> remove(T t, Node<T> node){
        if (node == null){
            return null;
        }
        else if (node.getElem().equals(t)){
            if (node.getPrev() != null){
                node.getPrev().setNext(node.getNext());
            }
            if (node.getNext() != null){
                node.getNext().setPrev(node.getPrev());
            }
            return node.getNext();
        }
        else if (node.getNext() == null){
            return node;
        }
        else {
            node.setNext(remove(t, node.getNext()));
            return node;
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

    private class DoublyIterator implements GeekbrainsIterator<T>{
        private Node<T> current;

        public DoublyIterator() {
            current = new Node<>(null, head, null);
        }

        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public T next() {
            if (current != null){
                current = current.getNext();
                return current.getElem();
            }
            else {
                return null;
            }
        }
    }
}

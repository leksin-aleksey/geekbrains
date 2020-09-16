package com.geekbrains.java.course;

public interface GeekbrainsList<T> extends GeekBrainsIterable<T> {
    boolean add(T t);

    boolean remove(T t);
}

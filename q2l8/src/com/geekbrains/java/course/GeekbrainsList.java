package com.geekbrains.java.course;

public interface GeekbrainsList<T> extends GeekbrainsIterable<T> {
    boolean add(T t);

    boolean remove(T t);
}

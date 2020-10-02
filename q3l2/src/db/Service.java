package db;

import java.util.Collection;

public interface Service<T> {
    Collection<T> findAll();
    T findById(int id);
//    void update(T object);
    boolean add(T object);
}

package com.example.iterable;
//
public interface Container<E> extends Iterable<E> {

    void add(E item);
    boolean remove(E item);
    boolean contains(E item);
    int size();
    boolean isEmpty();

}

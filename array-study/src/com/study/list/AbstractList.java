package com.study.list;

public abstract class AbstractList<E> implements List<E> {

    protected Integer size;

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FIND;
    }
}

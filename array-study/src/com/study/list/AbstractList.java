package com.study.list;

public abstract class AbstractList<E> implements List<E> {

    protected Integer size = 0;

    public void rangeCheck(Integer index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException(index + "下标越界");
        }
    }

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

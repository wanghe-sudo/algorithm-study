package com.study.list;

public interface List<T> {

    static final int DEFAULT_CAPACITY = 2;
    static final int ELEMENT_NOT_FIND = -1;

    public int size();

    public boolean isEmpty();

    public void clear();

    public void add(T element);

    public void add(int index, T element);

    public T get(int index);

    public T set(int index, T element);

    public T remove(int index);

    public int indexOf(T element);

    public boolean contains(T element);
}


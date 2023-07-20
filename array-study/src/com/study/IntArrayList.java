package com.study;

public class IntArrayList {
    /**
     * 当前容量
     */
    private int size;
    private int[] elements;

    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FIND = -1;

    public IntArrayList(int capacity) {
        if (capacity < DEFAULT_CAPACITY) {
            capacity = DEFAULT_CAPACITY;
        }
        this.elements = new int[capacity];
    }

    public IntArrayList() {
        // 调构造函数
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return size;
    }

    public boolean idEmpty() {
        return 0 == size;
    }

    /**
     * 清空所有元素
     */
    public void clear() {
        size = 0;
    }

    public void add(int element) {
        // size是集，就往对应 index放
        elements[size++] = element;
    }


    public void add(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index + ",size: " + size);
        }

        for (int i = size - 1; i >= index; i--) {
            elements[i+1] = elements[i ];
        }

        elements[index] = element;

        size++;

    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ",size: " + size);
        }
        return elements[index];
    }

    /**
     * 将原来的元素返回
     *
     * @param index
     * @param element
     * @return
     */
    public int set(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ",size: " + size);
        }
        int old = elements[index];
        elements[index] = element;
        return old;
    }

    public int remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("下标越界");
        }
        int old = get(index);
        // 将当前的之后
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
        return old;
    }

    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (element == elements[i]) {
                return i;
            }
        }
        return ELEMENT_NOT_FIND;
    }

    public boolean contains(int element) {
        return ELEMENT_NOT_FIND != indexOf(element);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("size=" + size + ", [");
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(elements[i]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

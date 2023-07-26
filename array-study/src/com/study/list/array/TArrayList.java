package com.study.list.array;

import com.study.list.AbstractList;

public class TArrayList<T> extends AbstractList<T> {
    /**
     * 当前容量
     */
    private int size;
    private T[] elements;

    public TArrayList(int capacity) {
        if (capacity < DEFAULT_CAPACITY) {
            capacity = DEFAULT_CAPACITY;
        }
        this.elements = (T[]) new Object[capacity];
    }

    public TArrayList() {
        // 调构造函数
        this(DEFAULT_CAPACITY);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return 0 == size;
    }

    /**
     * 清空所有元素
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * 末尾添加元素
     *
     * @param element
     */
    public void add(T element) {
        // size是集，就往对应 index放
        add(size, element);
    }


    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index + ",size: " + size);
        }
        // 判断当前容量+1是否足够
        ensureCapacity(size + 1);

        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }

        elements[index] = element;

        size++;

    }

    private void ensureCapacity(int capacity) {
        int oldCapacity = this.elements.length;
        if (oldCapacity < capacity) {
            // 扩容1.5倍
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            T[] newElements = (T[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
            //  System.arraycopy(); 可以实现内存拷贝
            System.out.println("发生扩容：扩容前：" + oldCapacity + "扩容后：" + newCapacity);
        }
    }

    public T get(int index) {
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
    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ",size: " + size);
        }
        T old = elements[index];
        elements[index] = element;
        return old;
    }

    public T remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("下标越界");
        }
        T old = get(index);
        // 将当前的之后
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        // 将size-1的位置置为null
        elements[--size] = null;
        return old;
    }

    public int indexOf(T element) {
        if (null == element) {
            for (int i = 0; i < size; i++) {
                if (null == elements[i]) {
                    return i;
                }
            }
            return ELEMENT_NOT_FIND;
        }

        for (int i = 0; i < size; i++) {
            if (element == elements[i]) {
                return i;
            }
        }
        return ELEMENT_NOT_FIND;
    }

    public boolean contains(T element) {
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

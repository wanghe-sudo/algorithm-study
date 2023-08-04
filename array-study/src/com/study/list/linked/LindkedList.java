package com.study.list.linked;


import com.study.list.AbstractList;

public class LindkedList<E> extends AbstractList<E> {


    private int size;
    private Node<E> first;
    private Node<E> last;

    static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        public Node() {
        }

        public Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", next=" + next +
                    '}';
        }

        @Override
        protected void finalize() throws Throwable {
            System.out.println("释放内存");
            super.finalize();
        }

    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public void add(int index, E element) {
        Node<E> next = node(index);
        Node<E> prev = next.prev;

        Node<E> eNode = new Node<>(element, prev, next);

        next.prev = eNode;
        if (prev == null) {
            first = eNode;
        } else {
            prev.next = eNode;

        }

        size++;

    }


    private Node<E> node(int index) {
        rangeCheck(index);
        Node<E> node = null;
        if (index <= (size >> 1)) {
            for (int i = 0; i < index; i++) {
                node = first.next;
            }
        } else {
            for (int i = size - 1; i > index; i--) {
                node = last.prev;
            }
        }
        return node;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public boolean contains(E element) {
        return false;
    }
}

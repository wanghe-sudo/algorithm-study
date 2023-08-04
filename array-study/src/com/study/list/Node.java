package com.study.list;

public class Node<E> {
    E element;
    Node<E> next;

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

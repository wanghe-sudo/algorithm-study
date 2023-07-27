package com.study.list.linked;

import com.study.list.AbstractList;

public class LinkedList<E> extends AbstractList<E> {
    /**
     * 存放第一个Node的内存地址
     */
    private Node<E> first;

    private static class Node<E> {
        E element;
        Node<E> next;

        public Node() {
        }

        public Node(E element, Node<E> next) {
            this.element = element;
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
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void clear() {
        this.size = 0;
        // 后面的都会逐步释放
        first = null;
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public void add(int index, E element) {
        if (0 == index) {
            // 当前元素是自己，下一个元素是first
            first = new Node<>(element, first);
        } else {
            Node<E> previous = node(index - 1);
            Node<E> eNode = new Node<E>();
            eNode.element = element;
            // 新节点指向下一个node
            eNode.next = previous.next;
            // 以上两步，完全可以由构造函数一把生成  Node<E> eNode = new Node<E>(element,previous.next);
            // 上一个节点指向当前node
            previous.next = eNode;
        }
        // 最后一个添加元素，不需要处理，因为最后一位是null，指向null即可
        size++;
    }

    private Node<E> node(Integer index) {
        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E old = node.element;
        // 将新的element放入对应的node中
        node.element = element;
        return old;
    }

    @Override
    public E remove(int index) {
        Node<E> old = first;
        if (0 == index) {
            first = first.next;
        } else {
            Node<E> prev = node(index - 1);
            old = prev.next;
            prev.next = prev.next.next;
        }
        size--;
        return old.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if (null == element) {
            for (int i = 0; i < size; i++) {
                if (null == node.element) {
                    return i;
                }
                node = node.next;
            }
            return ELEMENT_NOT_FIND;
        }

        for (int i = 0; i < size; i++) {
            if (element == node.element) {
                return i;
            }
        }
        return ELEMENT_NOT_FIND;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) == ELEMENT_NOT_FIND;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }
}



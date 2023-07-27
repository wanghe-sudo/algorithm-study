package com.study.list.linked;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);

        list.remove(0);
        System.gc();
        System.out.println("----------------------------------------------");

        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        list.remove(0);
        System.gc();
        System.out.println("----------------------------------------------");

        System.out.println(list);
    }
}

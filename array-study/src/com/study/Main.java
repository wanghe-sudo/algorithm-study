package com.study;

public class Main {
    public static void main(String[] args) {
        int[] array = {11, 22, 33};
        IntArrayList list = new IntArrayList();
        list.add(99);
        list.add(88);
        list.add(77);
        list.add(66);
        list.add(55);
        list.add(44);


        list.add(list.size()-1, 100);


        list.set(1,200);
        list.set(2,200);
        System.out.println(list);

    }
}
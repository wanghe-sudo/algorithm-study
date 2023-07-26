package com.study.list.array;

public class Main {
    public static void main(String[] args) {
/*        IntArrayList list = new IntArrayList();
        list.add(99);
        list.add(88);
        list.add(77);
        list.add(66);
        list.add(55);
        list.add(44);


        list.add(list.size()-1, 100);


        list.set(1,200);
        list.set(2,200);
        System.out.println(list);*/

        TArrayList<Persion> tal = new TArrayList<>();
        tal.add(new Persion(10, "zs"));
        tal.add(new Persion(12, "ls"));
        tal.add(new Persion(13, "ws"));
        tal.add(new Persion(15, "zl"));
        System.out.println(tal);

        tal.remove(0);

        System.gc();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(tal);


    }
}

class Persion {
    Integer age;
    String name;

    public Persion() {
    }

    public Persion(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("用户名为：" + this.name + "的类触发垃圾回收");
        super.finalize();
    }

    @Override
    public String toString() {
        return "Persion{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
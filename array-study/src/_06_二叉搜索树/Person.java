package _06_二叉搜索树;

public class Person implements Comparable<Person> {
    private int age;

    public Person(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
//        if (age > person.age) return 1;
//        if (age < person.age) return -1;
        return age - person.age;
    }
}

package Lesson4;

public class Cat {
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void info() {
        System.out.println("name - " + name);
        System.out.println("age - " + age);
    }

    @Override
    public String toString() {
        return String.format("name - %s, age - %s", name, age);
    }
}

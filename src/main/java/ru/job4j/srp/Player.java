package ru.job4j.srp;

public class Player {

    private int age;
    private String name;

    public Player(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public boolean isStudent() {
        return isStudent();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
/**
 * Нарешение принципа SRP в результате
 * реализации дополнительной логики.
 */

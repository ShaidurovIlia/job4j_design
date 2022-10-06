package ru.job4j.srp;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return age == player.age && Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
/**
 * Нарешение принципа SRP в результате
 * реализации дополнительной логики.
 */

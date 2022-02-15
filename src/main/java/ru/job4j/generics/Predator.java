package ru.job4j.generics;

public class Predator extends Animal {

    private String name = "Хищники";

    @Override
    public String toString() {
        return "Predator{"
                + "name='" + name
                + '\'' + '}';
    }
}

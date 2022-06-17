package ru.job4j.serialization;

import java.util.Arrays;

public class Dog {
    private boolean purebred;
    private int age;
    private String name;
    private Passport passport;
    private String[] colors;

    public Dog(boolean purebred, int age, String name, Passport passport, String[] colors) {
        this.purebred = purebred;
        this.age = age;
        this.name = name;
        this.passport = passport;
        this.colors = colors;
    }

    @Override
    public String toString() {
        return "Dog{" + "purebred="
                + purebred + ", age="
                + age + ", name='"
                + name + '\'' + ", passport="
                + passport + ", colors="
                + Arrays.toString(colors) + '}';
    }
}

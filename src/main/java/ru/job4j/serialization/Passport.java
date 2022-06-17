package ru.job4j.serialization;

public class Passport {
    private final int number;

    public Passport(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Passport{"
                + "number="
                + number + '}';
    }
}

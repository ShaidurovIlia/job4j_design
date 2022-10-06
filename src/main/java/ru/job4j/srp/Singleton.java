package ru.job4j.srp;

public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

/**
 * Singleton подразумевает,
 * что помимо своих основных обязанностей класс занимается
 * еще и контролированием количества своих экземпляров.
 */

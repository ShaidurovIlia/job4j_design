package ru.job4j.collection;

import java.util.*;

public class User {
    private int id;
    private String name;
    private int children;

    public User(int id, String name, int children) {
        this.id = id;
        this.name = name;
        this.children = children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id && children == user.children && name.equals(user.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {

        User  first = new User(24, "Ivan", 31);
        User second = new User(24, "Ivan", 31);

        Map<User, Object> userObjectMap = new HashMap<>();

        userObjectMap.put(first, new Object());
        userObjectMap.put(second, new Object());

        System.out.println(second.hashCode());
        System.out.println(first.hashCode());
        System.out.println(first.equals(second));
    }
}
package ru.job4j.collection;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        String date = String.format("%04d.%02d.%02d%n",
                birthday.get(Calendar.YEAR),
                birthday.get(Calendar.MONTH) + 1,
                birthday.get(Calendar.DAY_OF_MONTH));
        return "Name:" + name
                + " Children:" + children
                + " Birthday:" + date;
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
        return children == user.children
                && name.equals(user.name)
                && birthday.equals(user.birthday);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    public static void main(String[] args) {

        Calendar calendar = new GregorianCalendar(2000, Calendar.APRIL, 12);
        User  first = new User("Ivan", 12, calendar);
        User second = new User("Ivan", 12, calendar);
        Map<User, Object> userObjectMap = new HashMap<>();
        userObjectMap.put(first, new Object());
        userObjectMap.put(second, new Object());

        for (var entry : userObjectMap.entrySet()) {
            System.out.println(entry);
        }
    }
}

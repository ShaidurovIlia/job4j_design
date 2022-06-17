package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonDog {
    public static void main(String[] args) {
        final Dog dog = new Dog(true, 3, "Lord",
                new Passport(1418999966), new String[]{"Black", "White"});
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(dog));

        final String dogJson =
                "{"
                + "\"purebred\":true,"
                + "\"age\":3,"
                + "\"name\":Lord,"
                + "\"passport\":"
                + "{"
                + "\"number\":\"1418999966\""
                + "},"
                + "\"colors\":"
                + "[\"Black\",\"White\"]"
                + "}";
        final Dog dogj = gson.fromJson(dogJson, Dog.class);
        System.out.println(dogj);
    }
}

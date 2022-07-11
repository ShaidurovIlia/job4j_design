package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

public class JsonDog {
    public static void main(String[] args) {
        final Dog dog = new Dog(true, 3, "Lord",
                new Passport(1418999966), "Black", "White");
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
        System.out.println();

        JSONObject jsonDog = new JSONObject();
        jsonDog.put("purebred", dog.isPurebred());
        jsonDog.put("age", dog.getAge());
        jsonDog.put("name", dog.getName());
        jsonDog.put("passport", new JSONObject(dog.getPassport()));
        jsonDog.put("colors", new JSONArray(dog.getColors()));
        System.out.println(jsonDog);
        System.out.println(new JSONObject(dog));

    }
}

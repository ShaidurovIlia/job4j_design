package ru.job4j.ocp;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private Product product;
    private List<String> storage = new ArrayList<>();

    public Store() {
        product = new Product();
    }

    public String add(String name) {
        storage.add(name);
        return name;
    }

    public class Product {
        public void buy(double price) {
            System.out.println(price);
        }
    }
}
/**
 * Использование классов напрямую, без абстракций.
 */
package ru.job4j.food;

import java.util.ArrayList;
import java.util.List;

import static ru.job4j.food.ConstantFood.PERCENT_FRESH;
import static ru.job4j.food.Percent.expirationDate;

public class Warehouse implements Store {

    private final List<Food> warehouseFood = new ArrayList<>();

    @Override
    public boolean checkSort(Food food) {
        if (expirationDate(food) >= PERCENT_FRESH) {
            System.out.println("Send to the warehouse! Expiration date: " + expirationDate(food));
            warehouseFood.add(food);
        }
        return false;
    }

    @Override
    public List<Food> getFoods() {
        return List.copyOf(warehouseFood);
    }
}

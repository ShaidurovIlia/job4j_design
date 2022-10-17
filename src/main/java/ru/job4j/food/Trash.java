package ru.job4j.food;

import java.util.ArrayList;
import java.util.List;

import static ru.job4j.food.ConstantFood.PERCENT_TRASH;
import static ru.job4j.food.Percent.expirationDate;

public class Trash implements Store {

    private final List<Food> trashFood = new ArrayList<>();

    @Override
    public boolean checkSort(Food food) {
        if (expirationDate(food) <= PERCENT_TRASH) {
            System.out.println("Product is spoiled! Expiration date: " + expirationDate(food));
            trashFood.add(food);
        }
        return false;
    }

    @Override
    public List<Food> getFoods() {
        return List.copyOf(trashFood);
    }
}
package ru.job4j.food;

import java.util.List;
public interface Store {

    default boolean checkSort(Food food) {
        return false;
    }

    List<Food> getFoods();
}

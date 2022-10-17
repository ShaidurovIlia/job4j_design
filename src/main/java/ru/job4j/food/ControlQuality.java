package ru.job4j.food;

import java.util.List;

public class ControlQuality {

   private final List<Store> storage;

    public ControlQuality(List<Store> storeList) {
        this.storage = storeList;
    }

    public void distribution(Food food) {
        for (Store store : storage) {
            if (store.checkSort(food)) {
                break;
            }
        }
    }
}


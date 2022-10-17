package ru.job4j.food;

import java.util.ArrayList;
import java.util.List;

import static ru.job4j.food.ConstantFood.*;
import static ru.job4j.food.Percent.expirationDate;

public class Shop implements Store {

    private final List<Food> shopFoodList = new ArrayList<>();

    @Override
    public boolean checkSort(Food food) {
        if (expirationDate(food) > PERCENT_TRASH && expirationDate(food) < PERCENT_FRESH) {
            System.out.println("Expiration date: " + expirationDate(food));
            shopFoodList.add(food);
        }
            if (expirationDate(food) > PERCENT_TRASH && expirationDate(food) <= PERCENT_DISCOUNT) {
                food.setPrice(food.getPrice() - (food.getPrice()
                        * food.getDiscount() / PERCENT_FULL_FRESH));
                System.out.println("Expiration date less 25%: " + expirationDate(food));
                shopFoodList.add(food);
            }
            return false;
    }

    @Override
    public List<Food> getFoods() {
        return List.copyOf(shopFoodList);
    }
}


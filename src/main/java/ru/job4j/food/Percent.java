package ru.job4j.food;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;
public class Percent {
    public static double expirationDate(Food food) {
        LocalDate currentDate = LocalDate.now();
        LocalDate expirationDate = food.getExpiryDate();
        LocalDate createDate = food.getCreateDate();
        return (DAYS.between(expirationDate, currentDate) * 100.0)
                / (DAYS.between(expirationDate, createDate));
    }
}

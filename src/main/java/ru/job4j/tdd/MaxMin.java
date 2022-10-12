package ru.job4j.tdd;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        return cmp(value, obj -> obj <= 0, comparator);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return cmp(value, obj -> obj > 0, comparator);
    }

    public <T> T cmp(List<T> value, Predicate<Integer> predicate, Comparator<T> comparator) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("List is Empty");
        }
        T obj = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            if (predicate.test(comparator.compare(obj, value.get(i)))) {
                obj = value.get(i);
            }
        }
        return obj;
    }
}

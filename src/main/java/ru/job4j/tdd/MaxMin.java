package ru.job4j.tdd;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        BiPredicate<T, T> predicate = (obj1, obj2) -> comparator.compare(obj1, obj2) <= 0;
        return cmp(value, predicate);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        BiPredicate<T, T> predicate = (obj1, obj2) -> comparator.compare(obj1, obj2) > 0;
        return cmp(value, predicate);
    }

    public <T> T cmp(List<T> value, BiPredicate<T, T> predicate) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("List is Empty");
        }
        T obj = value.get(0);
        for (int i = 1; i < value.size(); i++) {
            T rsl = value.get(i);
            if (predicate.test(obj, rsl)) {
                obj = rsl;
            }
        }
        return obj;
    }
}

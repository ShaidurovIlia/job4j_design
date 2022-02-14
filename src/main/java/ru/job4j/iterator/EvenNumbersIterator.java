package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator {
    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (index < data.length - 1
                && data[index] % 2 != 0) {
                index++;
        }
        return index < data.length && data[index] % 2 == 0;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }
}

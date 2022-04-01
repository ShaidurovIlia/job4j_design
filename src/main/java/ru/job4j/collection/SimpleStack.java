package ru.job4j.collection;

public class SimpleStack<T> {

    private ForwardLinked<T> linked = new ForwardLinked<>();

    private int size = 0;

    public T pop() {
        if (size > 0) {
            size--;
        }
        return linked.deleteFirst();
    }

    public void push(T value) {
        linked.addFirst(value);
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
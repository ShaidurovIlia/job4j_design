package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

public class MemStore<T extends Base> implements Store<T> {

    private final Map<String, T> storage = new HashMap<>();

    @Override
    public void add(T model) {
        storage.put(model.getId(), model);
    }

    @Override
    public boolean replace(String id, T model) {
        storage.put(id, model);
        return storage.get(id).equals(model);
    }

    @Override
    public boolean delete(String id) {
        return !storage.containsKey(id);
    }

    @Override
    public T findById(String id) {
        return storage.get(id);
    }
}

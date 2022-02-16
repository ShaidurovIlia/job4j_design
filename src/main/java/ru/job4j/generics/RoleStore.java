package ru.job4j.generics;

public class RoleStore implements Store<Developer> {

    private final Store<Developer> role = new MemStore<>();

    @Override
    public void add(Developer model) {
        role.add(model);

    }

    @Override
    public boolean replace(String id, Developer model) {
        return role.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return role.delete(id);
    }

    @Override
    public Developer findById(String id) {
        return role.findById(id);
    }
}

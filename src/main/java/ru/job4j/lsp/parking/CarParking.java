package ru.job4j.lsp.parking;

import java.util.List;

public class CarParking implements Parking {

    @Override
    public boolean place(Transport transport) {
        return false;
    }

    @Override
    public boolean condition(Transport transport) {
        return false;
    }

    @Override
    public List<Transport> getAll() {
        return null;
    }
}

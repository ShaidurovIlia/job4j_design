package ru.job4j.lsp.parking;

public class Truck extends Transport {

    public Truck(String name, int sizePlace) {
        super(name, sizePlace);
        validSize(sizePlace);
    }

    private void validSize(int size) {
        if (size <= SIZE) {
            throw new IllegalArgumentException("The place is not suitable for a truck!");
        }
    }
}

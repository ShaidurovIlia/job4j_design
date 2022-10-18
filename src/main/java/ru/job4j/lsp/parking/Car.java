package ru.job4j.lsp.parking;

public class Car extends Transport {

    public Car(String name, int sizePlace) {
        super(name, sizePlace);
    }

    @Override
    public int getSize() {
        return SIZE;
    }
}

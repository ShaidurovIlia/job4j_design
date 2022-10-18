package ru.job4j.lsp.parking;

public abstract class Transport {

    public static final int SIZE = 1;

    private int sizePlace;

    private String name;

    public Transport(String name, int sizePlace) {
        this.name = name;
        this.sizePlace = sizePlace;
    }

    public Transport(String name) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return sizePlace;
    }

    public void setSize(int size) {
        this.sizePlace = size;
    }
}

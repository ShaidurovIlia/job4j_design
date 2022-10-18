package ru.job4j.lsp.parking;

import java.util.List;

public interface Parking {
    boolean place(Transport transport);

    boolean condition(Transport transport);

    List<Transport> getAll();
}

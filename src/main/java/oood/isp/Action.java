package oood.isp;

/**
 * Нарушает принцип ISP, т.к. интерфейс содержит более 3-х методов
 */

public interface Action {

    void eat();

    void sleep();

    void work();

    void play();
}

package oood.isp;

public class Dog implements Action {

    @Override
    public void eat() {
        System.out.println("Пес есть корм.");
    }

    @Override
    public void sleep() {
        System.out.println("Пес спит..zzz..");
    }

    @Override
    public void play() {
        System.out.println("Пес играет в мяч.");
    }

    /**
     * Нарушает принцип ISP, т.к. собака не умеет работать,
     * т.е, не верно выделена абстракция
     */

    @Override
    public void work() {
    }
    /**
     * Нарушает принцип ISP,
     * т.к. умение лаять должно быть выделено в отдельный интерфейс
     */

    public void bark() {
        System.out.println("Пес лает - гав гаф!");
    }
}

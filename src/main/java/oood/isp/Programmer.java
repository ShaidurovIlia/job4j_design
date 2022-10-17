package oood.isp;

public class Programmer implements Action {

    private String name = "Artur";

    @Override
    public void eat() {
        System.out.println(name + " Ест бутерброд");

    }

    @Override
    public void sleep() {
        System.out.println(name + " Спит в обед");
    }

    @Override
    public void work() {
        System.out.println(name + " Работат без выходных");
    }

    @Override
    public void play() {
        System.out.println(name + " Играет с друзьями");
    }
}

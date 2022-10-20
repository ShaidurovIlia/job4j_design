package oood.isp.menu;

public class SimpleMenuPrinter implements MenuPrinter {
    private static final String SEPARATOR = "---";

    @Override
    public void print(Menu menu) {
        menu.forEach(item -> System.out.println(paragraphIndent(item
                .getNumber())
                + item.getName()));
    }

    private String paragraphIndent(String number) {
        int index = number.split("\\.").length - 1;
        return SEPARATOR.repeat(index) + number;
    }
}

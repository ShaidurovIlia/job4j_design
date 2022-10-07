package ru.job4j.srp;


import java.util.function.Predicate;

public class ReportAccounting implements Report {

    private double wags;
    private String currency;
    private Store store;

    public ReportAccounting(double wags, String currency, Store store) {
        this.wags = wags;
        this.currency = currency;
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(Utility.SEPARATOR);
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(Utility.DATE_FORMAT.format(employee
                            .getHired().getTime())).append(";")
                    .append(Utility.DATE_FORMAT.format(employee
                            .getFired().getTime())).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(Utility.SEPARATOR);
        }
        return text.toString();
    }
}

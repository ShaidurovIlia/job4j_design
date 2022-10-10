package ru.job4j.srp;

import java.util.function.Predicate;

import static ru.job4j.srp.ReportEngine.DATE_FORMAT;

public class ReportAccounting implements Report {

    public static final double RUBLE_COURSE = 31;
    private Store store;

    public ReportAccounting(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(DATE_FORMAT.format(employee.getHired().getTime()))
                    .append(";")
                    .append(DATE_FORMAT.format(employee.getFired().getTime()))
                    .append(";")
                    .append(employee.getSalary() * RUBLE_COURSE).append("rub").append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}

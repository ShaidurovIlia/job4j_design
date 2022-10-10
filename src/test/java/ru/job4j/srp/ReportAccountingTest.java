package ru.job4j.srp;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;
import static ru.job4j.srp.ReportEngine.DATE_FORMAT;

class ReportAccountingTest {
    @Test
    void whenAccountingGenerate() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Artur", now, now, 1000);
        store.add(worker);
        Report report = new ReportAccounting(store);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(DATE_FORMAT.format(worker.getHired().getTime()))
                .append(";")
                .append(DATE_FORMAT.format(worker.getFired().getTime()))
                        .append(";")
                .append(worker.getSalary() * ReportAccounting.RUBLE_COURSE).append("rub")
                .append(";")
                .append(System.lineSeparator());
        assertThat(report.generate(e -> true)).isEqualTo(expected.toString());
    }
}
package ru.job4j.srp;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportAccountingTest {
    @Test
    void whenAccountingGenerate() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Artur", now, now, 1000);
        store.add(worker);
        Report report = new ReportAccounting(store, 31);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() * 31).append("rub").append(";")
                .append(System.lineSeparator());
        assertThat(report.generate(e -> true)).isEqualTo(expected.toString());
    }
}
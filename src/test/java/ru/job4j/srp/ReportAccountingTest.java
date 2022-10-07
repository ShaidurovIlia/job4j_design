package ru.job4j.srp;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportAccountingTest {

    @Test
    void whenAccountingGenerate() {
        MemStore store = new MemStore();
        Calendar calendar = Calendar.getInstance();
        Employee worker = new Employee("Artur", calendar, calendar, 1000);
        store.add(worker);
        Report report = new ReportAccounting(2.1, "$", store);
        StringBuilder expected = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(Utility.SEPARATOR)
                .append(worker.getName()).append(";")
                .append(Utility.SEPARATOR)
                .append(worker.getHired()).append(";")
                .append(Utility.SEPARATOR)
                .append(worker.getFired()).append(";")
                .append(Utility.SEPARATOR)
                .append(worker.getSalary()).append(";")
                .append(Utility.SEPARATOR);
        assertThat(report.generate(e -> true)).isEqualTo(expected.toString());

    }
}
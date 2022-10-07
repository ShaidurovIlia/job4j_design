package ru.job4j.srp;

import org.junit.jupiter.api.Test;
import java.util.Calendar;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.*;

class ReportHRTest {

    @Test
    void whenHRGenerate() {
        MemStore store = new MemStore();
        Calendar calendar = Calendar.getInstance();
        Employee worker = new Employee("Julia", calendar, calendar, 3500);
        Employee workerTwo = new Employee("Artur", calendar, calendar, 3000);
        store.add(worker);
        store.add(workerTwo);
        Report report = new ReportHR(store, Comparator.comparing(Employee :: getSalary).reversed());
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary; ").append(Utility.SEPARATOR)
                .append(Utility.SEPARATOR)
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(Utility.SEPARATOR)
                .append(workerTwo.getName()).append(";")
                .append(workerTwo.getSalary()).append(";")
                .append(Utility.SEPARATOR);
        assertThat(report.generate(e -> true)).isEqualTo(expected.toString());
    }
}
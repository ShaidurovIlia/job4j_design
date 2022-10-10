package ru.job4j.srp;

import org.junit.jupiter.api.Test;
import java.util.Calendar;


import static org.assertj.core.api.Assertions.*;

class ReportHRTest {

    @Test
    void whenHRGenerate() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        store.add(new Employee("Artur", now, now, 1000));
        store.add(new Employee("Julia", now, now, 5000));
        store.add(new Employee("Ivan", now, now, 3000));
        Report report = new ReportHR(store);
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append("Julia").append(";").append("5000.0").append(";")
                .append(System.lineSeparator())
                .append("Ivan").append(";").append("3000.0").append(";")
                .append(System.lineSeparator())
                .append("Artur").append(";").append("1000.0").append(";")
                .append(System.lineSeparator());
        assertThat(report.generate(e -> true)).isEqualTo(expected.toString());
    }
}
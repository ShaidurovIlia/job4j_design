package ru.job4j.srp;

import org.junit.jupiter.api.Test;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;
class ReportProgrammerTest {

    @Test
    public void whenProgrammersGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        String ln = System.lineSeparator();
        Employee worker = new Employee("Ivan", now, now, 5000);
        store.add(worker);
        Report report = new ReportProgrammer(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<!DOCTYPE html>").append(ln)
                .append("<html>").append(ln)
                .append("<head>").append(ln)
                .append("<title>Report employees</title>").append(ln)
                .append("</head>").append(ln)
                .append("<body>").append(ln)
                .append("<th>Name</th><th>Hired</th><th>Fired</th><th>Salary</th>")
                .append("</tr>").append(ln)
                .append("<tr>").append(ln)
                .append("<td>")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append("<tr>").append(ln)
                .append("</table>").append(ln)
                .append("</body>").append(ln)
                .append("</html>").append(ln);
        assertThat(report.generate(e -> true)).isEqualTo(expect.toString());
    }
}
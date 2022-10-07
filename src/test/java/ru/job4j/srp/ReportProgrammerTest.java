package ru.job4j.srp;

import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

class ReportProgrammerTest {

    @Test
    public void whenProgrammersGenerated() {
        MemStore store = new MemStore();
        Calendar calendar = Calendar.getInstance();
        Employee worker = new Employee("Ivan", calendar, calendar, 5000);
        store.add(worker);
        Report report = new ReportProgrammer(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<!DOCTYPE html>").append(Utility.SEPARATOR)
                .append("<html>").append(Utility.SEPARATOR)
                .append("<head>").append(Utility.SEPARATOR)
                .append("<title>Report employees</title>").append(Utility.SEPARATOR)
                .append("</head>").append(Utility.SEPARATOR)
                .append("<body>").append(Utility.SEPARATOR)
                .append("<th>Name</th><th>Hired</th><th>Fired</th><th>Salary</th>")
                .append("</tr>").append(Utility.SEPARATOR)
                .append("<tr>").append(Utility.SEPARATOR)
                .append("<td>").append(worker.getName()).append(";").append("</td>")
                .append("<td>").append(Utility.DATE_FORMAT.
                        format(worker.getHired().getTime())).append("</td>")
                .append("<td>").append(Utility.DATE_FORMAT
                        .format(worker.getFired().getTime())).append("</td>")
                .append("<td>").append(worker.getSalary()).append("</td>")
                .append("</tr>")
                .append(Utility.SEPARATOR)
                .append("</table>").append(Utility.SEPARATOR)
                .append("</body>").append(Utility.SEPARATOR)
                .append("</html>").append(Utility.SEPARATOR);
        assertThat(report.generate(e -> true)).isEqualTo(expect.toString());
    }
}
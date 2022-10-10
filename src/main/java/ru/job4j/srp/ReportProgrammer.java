package ru.job4j.srp;


import java.util.function.Predicate;

import static ru.job4j.srp.ReportEngine.DATE_FORMAT;

public class ReportProgrammer implements Report {
    private Store store;

    public ReportProgrammer(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        String ln = System.lineSeparator();
            text.append("<!DOCTYPE html>").append(ln)
                    .append("<html>").append(ln)
                    .append("<head>").append(ln)
                    .append("<title>Report employees</title>").append(ln)
                    .append("</head>").append(ln)
                    .append("<body>").append(ln)
                    .append("<th>Name;Hired;Fired;Salary</th>")
                    .append("</tr>")
                    .append(ln);
            for (Employee employee : store.findBy(filter)) {
                text.append("<tr>").append(ln)
                        .append("<td>")
                        .append(employee.getName()).append(";")
                        .append(DATE_FORMAT.format(employee.getHired().getTime()))
                        .append(";")
                        .append(DATE_FORMAT.format(employee.getFired().getTime())).
                        append(";")
                        .append(employee.getSalary()).append(";")
                        .append("<tr>").append(ln);
            }
        text.append("</table>").append(ln)
                .append("</body>").append(ln)
                .append("</html>").append(ln);
        return text.toString();
    }
}

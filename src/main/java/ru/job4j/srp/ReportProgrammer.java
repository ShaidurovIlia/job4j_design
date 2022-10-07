package ru.job4j.srp;

import java.util.function.Predicate;

public class ReportProgrammer implements Report {
    private Store store;

    public ReportProgrammer(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
            text.append("<!DOCTYPE html>").append(Utility.SEPARATOR)
                    .append("<html>").append(Utility.SEPARATOR)
                    .append("<head>").append(Utility.SEPARATOR)
                    .append("<title>Report employees</title>").append(Utility.SEPARATOR)
                    .append("</head>").append(Utility.SEPARATOR)
                    .append("<body>").append(Utility.SEPARATOR)
                    .append("<th>Name</th><th>Hired</th><th>Fired</th><th>Salary</th>")
                    .append("</tr>")
                    .append(Utility.SEPARATOR);
            for (Employee employee : store.findBy(filter)) {
                text.append("<tr>").append(Utility.SEPARATOR)
                        .append("<td>").append(employee.getName()).append(";").append("</td>")
                        .append("<td>").append(Utility.DATE_FORMAT.format(employee.getHired()
                                .getTime())).append("</td>")
                        .append("<td>").append(Utility.DATE_FORMAT.format(employee.getFired()
                                .getTime())).append("</td>")
                        .append("<td>").append(employee.getSalary()).append("</td>")
                        .append("</tr>")
                        .append(Utility.SEPARATOR);
            }
        text.append("</table>").append(Utility.SEPARATOR)
                .append("</body>").append(Utility.SEPARATOR)
                .append("</html>").append(Utility.SEPARATOR);
        return text.toString();
    }
}

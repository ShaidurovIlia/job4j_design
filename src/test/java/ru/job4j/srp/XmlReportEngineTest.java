package ru.job4j.srp;

import org.junit.Test;

import javax.xml.bind.JAXBException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

class XmlReportEngineTest {

    @Test
    void whenXmlGenerated() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Employee employee = new Employee("Artur", now, now, 1900);
        store.add(employee);
        Report engine = new XmlReportEngine(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n")
                .append("<store>\n")
                .append("<employees>\n")
                .append("<employee>\n")
                .append(String.format("<fired>%s</fired>\n", dateFormat.format(employee.getFired()
                        .getTime())))
                .append(String.format("<hired>%s</hired>\n", dateFormat.format(employee.getHired()
                        .getTime())))
                .append(String.format("<name>%s</name>\n", employee
                        .getName()))
                .append(String.format(" <salary>%s</salary>\n", employee.getSalary()))
                .append("</employee>\n")
                .append("<employees>\n");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}
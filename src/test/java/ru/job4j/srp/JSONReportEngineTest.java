package ru.job4j.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

class JSONReportEngineTest {

    @Test
    public void whenJSONGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Gson gson = new GsonBuilder().create();
        Employee employee = new Employee("Julia", now, now, 1300);
        store.add(employee);
        Report engine = new JSONReportEngine(store);
        StringBuilder expect = new StringBuilder();
        expect.append(String.format("[{\"name\":\"%s\",", employee.getName()))
                .append(String.format("\"hired\":%s,", gson.toJson(employee.getHired())))
                .append(String.format("\"fired\":%s,", gson.toJson(employee.getFired())))
                .append(String.format("\"salary\":%s},", employee.getSalary()));

        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}
package ru.job4j.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.function.Predicate;

public class JSONReportEngine implements Report {
    private Store store;
    private Gson gsonReport;
    private GsonBuilder builder;

    public JSONReportEngine(Store store, Gson gsonReport, GsonBuilder builder) {
        this.store = store;
        this.gsonReport = gsonReport;
        this.builder = builder;
    }

    public JSONReportEngine() {
    }

    public JSONReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        return gsonReport.toJson(store.findBy(filter));
    }
}

package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(this.path))) {
            values.putAll(reader.lines()
                    .filter(x -> !"".equals(x) && x.charAt(0) != '#')
                    .peek(x -> {
                        if (x.indexOf('=') == -1 || x.charAt(0) == '='
                                || x.charAt(x.length() - 1) == '=') {
                            throw new IllegalArgumentException();
                        }
                    })
                    .collect(Collectors.toMap(k -> k.split("=")[0],
                            v -> v.split("=")[1])));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
       return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(
                new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}

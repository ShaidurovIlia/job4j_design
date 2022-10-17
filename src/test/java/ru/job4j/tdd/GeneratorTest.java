package ru.job4j.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Disabled("The test is temporarily disabled")
class GeneratorTest {

    @Test()
    public void whenCorrect() {
        String template = "template ${template}";
        Template temp = new Template();
        Map<String, String> args = new HashMap<>();
        args.put("template", "test");
        assertThat(temp.produce(template, args)).isEqualTo("template test");
    }

    @Test()
    public void whenNotCorrect() {
        String template = "template ${template}";
        Template temp = new Template();
        Map<String, String> args = new HashMap<>();
        args.put("template", "test");
        args.put("test", "test");
        assertThrows(IllegalArgumentException.class, () -> temp.produce(template, args));
    }

    @Test
    public void whenIsEmpty() {
        String template = "template ${template}";
        Template temp = new Template();
        Map<String, String> args = new HashMap<>();
        assertThrows(IllegalArgumentException.class, () -> temp.produce(template, args));
    }

    @Test()
    public void whenNoKeysInMap() {
        String template = "template ${template} and test ${key}";
        Template temp = new Template();
        Map<String, String> args = new HashMap<>();
        args.put("template", "test");
        assertThrows(IllegalArgumentException.class, () -> temp.produce(template, args));
    }

    @Test()
    public void whenNotKeysInTemplate() {
        String template = "template";
        Template temp = new Template();
        Map<String, String> args = new HashMap<>();
        assertThrows(IllegalArgumentException.class, () -> temp.produce(template, args));
    }
}
package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("Ilya"), is("Shaydurov"));
        assertThat(config.value("surname"), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWitComment() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("Ilya"), is("Shaydurov"));
        assertThat(config.value("#Comment"), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWithNullKeyAndEmptyString() {
        String path = "./data/pair_with_emptyString.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("Anna"), is("Efimova"));
        assertThat(config.value("Maxim"), is("Kilin"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithException() {
        String path = "data/pair_with_IllegalArgument.properties";
        Config config = new Config(path);
        config.load();
    }
}
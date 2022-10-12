package ru.job4j.tdd;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MaxMinTest {
    @Test
    public void whenMaxIs65() {
        List<Integer> list = Arrays.asList(65, 12, 53, 1, 56);
        MaxMin max = new MaxMin();
        Comparator<Integer> com = Comparator.comparingInt(o -> o);
        assertThat(max.max(list, com)).isEqualTo(65);
    }

    @Test
    public void whenMinIs1() {
        List<Integer> list = Arrays.asList(65, 12, 53, 1, 56);
        MaxMin min = new MaxMin();
        Comparator<Integer> com = Comparator.comparingInt(o -> o);
        assertThat(min.min(list, com)).isEqualTo(1);
    }
}
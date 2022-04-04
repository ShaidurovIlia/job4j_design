package ru.job4j.iterator;

import static org.hamcrest.core.Is.is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(input, is(Arrays.asList(1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(input, is(Arrays.asList(0, 1, 2, 3)));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddAfterLastWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 4, 3);
    }

    @Test
    public void whenRemoveIfTruePredicate() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 10, 12, 15));
        ListUtils.removeIf(input, x -> x % 2 != 0);
        assertThat(input, is(Arrays.asList(0, 2, 10, 12)));
    }

    @Test
    public void whenReplaceIfTruePredicateEmptyInput() {
        List<Integer> input = new ArrayList<>();
        ListUtils.replaceIf(input, x -> x % 2 != 0, 1);
        assertThat(input, is(Arrays.asList()));
    }

    @Test
    public void whenRemoveAllCollection() {
        List<Integer> input = new ArrayList<>(List.of(0, 1, 3, 5, 7, 9));
        List<Integer> remove = List.of(1, 5, 12, 9);
        ListUtils.removeAll(input, remove);
        assertThat(input, is(List.of(0, 3, 7)));
    }

    @Test
    public void whenRemoveAllCollectionEmptyRemoveCollection() {
        List<Integer> input = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5));
        List<Integer> remove = List.of();
        ListUtils.removeAll(input, remove);
        assertThat(input, is(List.of(0, 1, 2, 3, 4, 5)));
    }
}
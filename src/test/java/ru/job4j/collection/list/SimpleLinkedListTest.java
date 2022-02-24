package ru.job4j.collection.list;

import org.junit.Test;

import java.util.Iterator;

import org.hamcrest.core.Is;

import static org.junit.Assert.*;

    public class SimpleLinkedListTest {

        @Test
        public void whenAddAndGet() {
            List<Integer> list = new SimpleLinkedList<>();
            list.add(1);
            list.add(2);
            assertThat(list.get(0), Is.is(1));
            assertThat(list.get(1), Is.is(2));
        }

        @Test(expected = IndexOutOfBoundsException.class)
        public void whenGetFromOutOfBoundThenExceptionThrown() {
            List<Integer> list = new SimpleLinkedList<>();
            list.add(1);
            list.add(2);
            list.get(2);
        }

        @Test
        public void whenAddIterHasNextTrue() {
            List<Integer> list = new SimpleLinkedList<>();
            list.add(1);
            Iterator<Integer> it = list.iterator();
            assertThat(it.hasNext(), Is.is(true));
        }

        @Test
        public void whenAddIterNextOne() {
            List<Integer> list = new SimpleLinkedList<>();
            list.add(1);
            Iterator<Integer> it = list.iterator();
            assertThat(it.next(), Is.is(1));
        }

        @Test
        public void whenEmptyIterHashNextFalse() {
            List<Integer> list = new SimpleLinkedList<>();
            Iterator<Integer> it = list.iterator();
            assertThat(it.hasNext(), Is.is(false));
        }

        @Test
        public void whenAddIterMultiHasNextTrue() {
            List<Integer> list = new SimpleLinkedList<>();
            list.add(1);
            Iterator<Integer> it = list.iterator();
            assertThat(it.hasNext(), Is.is(true));
            assertThat(it.hasNext(), Is.is(true));
        }

        @Test
        public void whenAddIterNextOneNextTwo() {
            List<Integer> list = new SimpleLinkedList<>();
            list.add(1);
            list.add(2);
            Iterator<Integer> it = list.iterator();
            assertThat(it.next(), Is.is(1));
            assertThat(it.next(), Is.is(2));
        }

        @Test
        public void whenGetIteratorTwiceThenEveryFromBegin() {
            List<Integer> list = new SimpleLinkedList<>();
            list.add(1);
            list.add(2);
            Iterator<Integer> first = list.iterator();
            assertThat(first.hasNext(), Is.is(true));
            assertThat(first.next(), Is.is(1));
            assertThat(first.hasNext(), Is.is(true));
            assertThat(first.next(), Is.is(2));
            assertThat(first.hasNext(), Is.is(false));
            Iterator<Integer> second = list.iterator();
            assertThat(second.hasNext(), Is.is(true));
            assertThat(second.next(), Is.is(1));
            assertThat(second.hasNext(), Is.is(true));
            assertThat(second.next(), Is.is(2));
            assertThat(second.hasNext(), Is.is(false));
        }

        @Test
        public void whenAdd4AndGet4() {
            List<Integer> list = new SimpleLinkedList<>();
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            assertThat(list.get(0), Is.is(1));
            assertThat(list.get(1), Is.is(2));
            assertThat(list.get(2), Is.is(3));
            assertThat(list.get(3), Is.is(4));
        }
    }

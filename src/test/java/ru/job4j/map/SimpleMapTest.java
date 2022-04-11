package ru.job4j.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

import static org.hamcrest.core.Is.is;

public class SimpleMapTest {

    @Test
    public void whenPutThirdPair() {
        SimpleMap<Integer, String> name = new SimpleMap<>();
        assertTrue(name.put(18, "Ivan"));
        assertTrue(name.put(21, "Egor"));
        assertTrue(name.put(30, "Maxim"));
    }

    @Test
    public void whenPutWithCollision() {
        SimpleMap<Integer, String> name = new SimpleMap<>();
        name.put(18, "Ivan");
        name.put(21, "Egor");
        name.put(30, "Maxim");
        assertFalse(name.put(22, "Elena"));
    }

    @Test
    public void whenGetKeyEighteen() {
        SimpleMap<Integer, String> name = new SimpleMap<>();
        name.put(18, "Ivan");
        name.put(21, "Egor");
        name.put(30, "Maxim");
        assertThat(name.get(18), is("Ivan"));
    }

    @Test
    public void whenGetNull() {
        SimpleMap<Integer, String> name = new SimpleMap<>();
        name.put(18, "Ivan");
        name.put(21, "Egor");
        name.put(30, "Maxim");
        assertNull(name.get(44));
    }

    @Test
    public void whenRemoveKeyEighteen() {
        SimpleMap<Integer, String> name = new SimpleMap<>();
        name.put(18, "Ivan");
        name.put(21, "Egor");
        name.put(30, "Maxim");
        assertTrue(name.remove(21));
    }

    @Test
    public void whenRemoveKeyFalse() {
        SimpleMap<Integer, String> name = new SimpleMap<>();
        name.put(18, "Ivan");
        name.put(21, "Egor");
        name.put(30, "Maxim");
        assertFalse(name.remove(51));
    }

    @Test
    public void whenIteratorThreeKey() {
        SimpleMap<Integer, String> name = new SimpleMap<>();
        name.put(18, "Ivan");
        name.put(21, "Egor");
        name.put(30, "Maxim");
        Iterator<Integer> it = name.iterator();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        assertFalse(it.hasNext());
    }

    @Test (expected = NoSuchElementException.class)
    public void  whenIteratorNoSuchElement() {
        SimpleMap<Integer, String> name = new SimpleMap<>();
        name.put(18, "Ivan");
        name.put(21, "Egor");
        name.put(30, "Maxim");
        Iterator<Integer> it = name.iterator();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
        it.next();
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenIteratorConcurrentModification() {
        SimpleMap<Integer, String> name = new SimpleMap<>();
        name.put(18, "Ivan");
        name.put(21, "Egor");
        name.put(30, "Maxim");
        Iterator<Integer> it = name.iterator();
        assertTrue(it.hasNext());
        it.next();
        name.put(55, "Petr");
        assertTrue(it.hasNext());
        it.next();
        assertTrue(it.hasNext());
        it.next();
    }
}
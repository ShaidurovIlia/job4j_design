package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count;
    private int modCount;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }
        int index = indexFor(hash(key.hashCode()));
        boolean rsl = table[index] == null;
        if (rsl) {
            table[index] = new MapEntry<K, V>(key, value);
            count++;
            modCount++;
        }
        return rsl;
    }

    private int hash(int hashCode) {
        return hashCode ^ hashCode >>> 16;
    }

    private int indexFor(int hash) {
        return (capacity - 1) & hash;
    }

    private void expand() {
        MapEntry<K, V>[] copyTable = new MapEntry[capacity * 2];
        for (MapEntry<K, V> copy : table) {
            if (copy != null) {
                copyTable[indexFor(hash(copy.key.hashCode()))] = copy;
            }
        }
        table = copyTable;
    }

    @Override
    public V get(K key) {
        V result = null;
        int index = indexFor(hash(key.hashCode()));
        if (table[index] != null
                && table[index].key.equals(key)) {
            result = (V) table[index].value;
        }
        return result;
    }

    @Override
    public boolean remove(K key) {
        int index = indexFor(hash(key.hashCode()));
        boolean rsl = table[index] != null
                && table[index].key.equals(key);
        if (rsl) {
            table[index] = null;
            modCount++;
            count--;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private int index;
            private final int expectModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                boolean result = false;
                for (int i = index; i < table.length; i++) {
                    if (table[i] != null) {
                        result = true;
                        break;
                    }
                    index++;
                }
                return result;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[index++].key;
            }
        };
    }

    private static class MapEntry<K, V> {
        private K key;
        private V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}

package ru.job4j.collection.tree;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface Tree<E> {
    boolean add(E parent, E child);

    boolean isBinary();

    Optional<Node<E>> findBy(E value);

    class Node<E> {
        private final E value;
        private final List<Node<E>> children = new ArrayList<>();

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public List<Node<E>> getChildren() {
            return children;
        }
    }
}

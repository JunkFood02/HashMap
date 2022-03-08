package com.hustunique.android;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

public class HashMap<T, E> {
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75F;
    private int initialCapacity = DEFAULT_INITIAL_CAPACITY;
    private int arraySize = 0;
    private List<LinkedList> linkedLists = new ArrayList<>(initialCapacity);

    public HashMap() {
        for (int i = 0; i < initialCapacity; i++) {
            linkedLists.add(new LinkedList());
        }
    }

    public boolean containsKey(T key) {
        return false;
    }

    public E put(T key, E value) {
        return null;
    }


    public E get(T key) {
        return null;
    }

    public E remove(T key) {
        return null;
    }


    public void forEach(BiConsumer<T, E> action) {

    }


    class Node {
        T key;
        E value;
        Node next;

        public Node() {
        }
    }

    class LinkedList {
        private final Node head = new Node();
        int size = 0;

        public E insert(Node node) {
            return null;
        }

        private E get(T key) {
            return null;
        }

        private E remove(T key) {
            return null;
        }


    }
}

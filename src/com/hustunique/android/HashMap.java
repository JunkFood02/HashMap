package com.hustunique.android;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiConsumer;

public class HashMap<T, E> {
    private static final int initialCapacity = 16;
    private final List<LinkedList> linkedLists = new ArrayList<>(initialCapacity);

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

    public void forEach(BiConsumer<T, E> consumer) {
    }


    class LinkedList {

        class Node {
            T key;
            E value;
            Node next;

            Node(T key, E value) {

            }

            Node() {
            }
        }


    }
}

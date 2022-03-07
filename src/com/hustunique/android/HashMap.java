package com.hustunique.android;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiConsumer;

public class HashMap<T, E> {
    private static int initialCapacity = 16;
    private static int ModValue = 16;
    private static final float defaultCapacity = 0.75;
    private int sumSize = 0;
    private List<LinkedList> nodeLists = new ArrayList<>(initialCapacity);

    public HashMap() {
        for (int i = 0; i < initialCapacity; i++) {
            nodeLists.add(new LinkedList());
        }
    }

    public boolean containsKey(T key) {
        for (Node node : nodeLists.get(hash(key)))
            if (node.key.equals(key))
                return true;
        return false;
    }

    public void put(T key, E value) {
        sumSize++;
        nodeLists.get(hash(key)).insert(new Node(key, value));
        if ((float)sumSize >= initialCapacity * defaultCapacity) resize(initialCapacity << 1);
    }


    public E get(T key) {
        return nodeLists.get(hash(key)).get(key).value;
    }

    public E remove(T key) {

        Node preNode = nodeLists.get(hash(key)).head;
        Node node = preNode.next;
        while (node != null) {
            if (key == node.key) {
                preNode.next = node.next;
                sumSize--;
                return node.value;
            }
            preNode = node;
            node = node.next;
        }
        return null;
    }

    private void resize(int newCapacity){
        List<LinkedList> newLists = new ArrayList<>(newCapacity);
        transfer(newLists, newCapacity);
        nodeLists = newLists;
        initialCapacity = newCapacity;
    }

    private void transfer(List<LinkedList> newLists , int newCapacity){
        ModValue = newCapacity ;
        nodeLists.forEach(list -> {
            for (Node node : list) {
                newLists.get(hash(node.key)).insert(node);
            }
        });
    }


    public void forEach(BiConsumer<T, E> consumer) {
        nodeLists.forEach(list -> {
            for (Node node : list) {
                consumer.accept(node.key, node.value);
            }
        });
    }

    private int hash(T key) {
        return (key.hashCode() ^ (key.hashCode() >> 4)) & (ModValue - 1);
    }

    class Node {
        T key;
        E value;
        Node next;

        public Node(T key, E value) {
            this.key = key;
            this.value = value;
            next = null;
        }

        public Node() {
        }
    }

    class LinkedList implements Iterable<Node> {
        Node head = new Node();
        int size = 0;

        public void insert(Node node) {
            Node currentNode = head;
            while (null != currentNode.next) {
                if (currentNode.next.key == node.key) {
                    node.next = currentNode.next.next;
                    currentNode.next = node;
                    return;
                }
                currentNode = currentNode.next;
            }
            currentNode.next = node;
            size++;
        }

        public Node get(T key) {
            Node currentNode = head;
            while (null != currentNode.next) {
                currentNode = currentNode.next;
                if (currentNode.key == key)
                    break;
            }
            if (currentNode.key == key)
                return currentNode;
            else return null;
        }

        class NodeIterator implements Iterator<Node> {
            private Node now = head;

            @Override
            public boolean hasNext() {
                return now.next != null;
            }

            @Override
            public Node next() {
                if (hasNext())
                    now = now.next;
                return now;
            }
        }

        @Override
        public Iterator<Node> iterator() {
            return new NodeIterator();
        }

    }
}

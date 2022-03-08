package com.hustunique.android;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiConsumer;

public class HashMap<T, E> {
    private static int initialCapacity = 16;
    private static int ModValue = 16;
    private static final float defaultCapacity = 0.75F;
    private int arraySize;
    private List<LinkedList> nodeLists = new ArrayList<>(initialCapacity);

    public HashMap() {
        for (int i = 0; i < initialCapacity; i++) {
            nodeLists.add(new LinkedList());
        }
    }

    public boolean containsKey(T key) {
        if (key == null) return false;
        for (Node node : nodeLists.get(hash(key)))
            if (node.key.equals(key))
                return true;
        return false;
    }

    public E put(T key, E value) {
        if (key == null) return null;
        int hashcode = hash(key);
        if (nodeLists.get(hashcode).size == 0)
            arraySize++;
        if (arraySize > defaultCapacity * initialCapacity)
            resize(initialCapacity * 2);
        return nodeLists.get(hashcode).insert(new Node(key, value));
    }


    public E get(T key) {
        return null == key ? null : nodeLists.get(hash(key)).get(key);
    }

    public E remove(T key) {
        int hashcode = hash(key);
        if (nodeLists.get(hashcode).size == 1)
            arraySize--;
        return nodeLists.get(hashcode).remove(key);
    }

    private void resize(int newCapacity) {
        List<LinkedList> newLists = new ArrayList<>(newCapacity);
        transfer(newLists, newCapacity);
        nodeLists = newLists;
        initialCapacity = newCapacity;
    }

    private void transfer(List<LinkedList> newLists, int newCapacity) {
        ModValue = newCapacity;
        nodeLists.forEach(list -> {
            for (Node node : list) {
                newLists.get(hash(node.key)).insert(node);
            }
        });
    }


    public void forEach(BiConsumer<T, E> action) {
        nodeLists.forEach(list -> {
            for (Node node : list) {
                action.accept(node.key, node.value);
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
        private final Node head = new Node();
        int size = 0;

        public E insert(Node node) {
            Node currentNode = head;
            while (null != currentNode.next) {
                if (currentNode.next.key.equals(node.key)) {
                    node.next = currentNode.next.next;
                    currentNode.next = node;
                    return node.value;
                }
                currentNode = currentNode.next;
            }
            currentNode.next = node;
            size++;
            return null;
        }

        private E get(T key) {
            Node currentNode = head;
            while (null != currentNode.next) {
                currentNode = currentNode.next;
                if (currentNode.key.equals(key))
                    break;
            }
            if (currentNode.key.equals(key))
                return currentNode.value;
            else return null;
        }

        private E remove(T key) {
            Node currentNode = head;
            while (currentNode.next != null) {
                if (key.equals(currentNode.next.key)) {
                    Node removedNode = currentNode.next;
                    currentNode.next = currentNode.next.next;
                    size--;
                    return removedNode.value;
                }
            }
            return null;
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

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiConsumer;

public class HashMap<T, E> {
    private static final int initialCapacity = 16;
    int i = 0;
    List<LinkedList> nodeLists = new ArrayList<>(initialCapacity);

    public HashMap() {
        for (int i = 0; i < initialCapacity; i++) {
            nodeLists.add(new LinkedList());
        }
    }

    public void put(T key, E value) {
        nodeLists.get(hash(key)).insert(new Node(key, value));
    }

    public E get(T key) {
        return nodeLists.get(hash(key)).get(key).value;
    }

    public void remove(T key) {

        Node preNode = nodeLists.get(hash(key)).head;
        Node node = preNode.next;
        while (node != null) {
            if (key == node.key) {
                preNode.next = node.next;
                return;
            }
            preNode = node;
            node = node.next;
        }
    }

    public void forEach(BiConsumer<T, E> consumer) {
        nodeLists.forEach(list -> {
            for (Node node : list) {
                consumer.accept(node.key, node.value);
            }
        });
    }

    private int hash(T key) {
        return key.hashCode() % initialCapacity;
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

        @NotNull
        @Override
        public Iterator<Node> iterator() {
            return new NodeIterator();
        }

    }
}

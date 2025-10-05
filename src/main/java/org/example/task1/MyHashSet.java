package org.example.task1;

import java.util.Objects;

public class MyHashSet<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private Node<T>[] table;
    private int size;
    private int threshold;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        table = (Node<T>[]) new Node[DEFAULT_CAPACITY];
        threshold = (int) (DEFAULT_CAPACITY * LOAD_FACTOR);
    }

    public boolean add(T value) {
        if (value == null) throw new IllegalArgumentException("null not supported");
        int idx = index(hash(value.hashCode()));
        for (Node<T> n = table[idx]; n != null; n = n.next) {
            if (Objects.equals(n.value, value)) return false;
        }
        table[idx] = new Node<>(value, table[idx]);
        if (++size > threshold) resize();
        return true;
    }

    public boolean remove(T value) {
        int idx = index(hash(value.hashCode()));
        Node<T> prev = null, cur = table[idx];
        while (cur != null) {
            if (Objects.equals(cur.value, value)) {
                if (prev == null) table[idx] = cur.next;
                else prev.next = cur.next;
                size--;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }

    private static int hash(int h) { return h ^ (h >>> 16); }
    private int index(int h) { return (table.length - 1) & h; }

    @SuppressWarnings("unchecked")
    private void resize() {
        Node<T>[] old = table;
        Node<T>[] newTab = (Node<T>[]) new Node[old.length << 1];
        for (Node<T> head : old) {
            while (head != null) {
                Node<T> next = head.next;
                int idx = (newTab.length - 1) & hash(head.value.hashCode());
                head.next = newTab[idx];
                newTab[idx] = head;
                head = next;
            }
        }
        table = newTab;
        threshold = (int) (table.length * LOAD_FACTOR);
    }

    private static final class Node<T> {
        final T value;
        Node<T> next;
        Node(T value, Node<T> next) { this.value = value; this.next = next; }
    }
}

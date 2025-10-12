package org.example.task1;

import java.util.Collection;

public class MyLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public void add(T value) {
        Node<T> l = last;
        Node<T> newNode = new Node<>(l, value, null);
        last = newNode;
        if (l == null) first = newNode;
        else l.next = newNode;
        size++;
    }

    public T get(int index) {
        checkIndex(index);
        return node(index).item;
    }

    public T remove(int index) {
        checkIndex(index);
        Node<T> x = node(index);
        T val = x.item;
        Node<T> p = x.prev, n = x.next;
        if (p == null) first = n; else p.next = n;
        if (n == null) last = p; else n.prev = p;
        size--;
        return val;
    }

    public void addAll(Collection<? extends T> c) {
        for (T t : c) add(t);
    }

    private void checkIndex(int idx) {
        if (idx < 0 || idx >= size) throw new IndexOutOfBoundsException();
    }

    private Node<T> node(int index) {
        if (index < (size >> 1)) {
            Node<T> x = first;
            for (int i = 0; i < index; i++) x = x.next;
            return x;
        } else {
            Node<T> x = last;
            for (int i = size - 1; i > index; i--) x = x.prev;
            return x;
        }
    }

    private static final class Node<T> {
        Node<T> prev;
        T item;
        Node<T> next;
        Node(Node<T> prev, T item, Node<T> next) { this.prev = prev; this.item = item; this.next = next; }
    }
}
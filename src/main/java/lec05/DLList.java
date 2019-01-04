package lec05;

import java.util.ArrayList;
import java.util.List;

/**
 * The Double-linked list used in TwoDimDLList.
 *
 * Copied from Proj1A before submission, so implementation might be flawed.
 */
public class DLList<T> {

    private DequeNode<T> sentinel;
    private int size;

    private static class DequeNode<T> {

        public T item;
        public DequeNode<T> prev;
        public DequeNode<T> next;

        public DequeNode() {
        }

        public DequeNode(T item, DequeNode<T> prev, DequeNode<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    public DLList() {
        sentinel = new DequeNode<>();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public T get(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException(String.format("Index %d is out of bound.", index));
        }
        DequeNode<T> node = sentinel.next;
        for (int i = 0;
            i < index && node != sentinel;
            i++, node = node.next) {
        }

        if (node == sentinel) {
            throw new IndexOutOfBoundsException(String.format("Index %d is out of bound.", index));
        }
        return node.item;
    }

    public int size() {
        return size;
    }

    public List<T> toList() {
        DequeNode<T> node = sentinel.next;
        List<T> res = new ArrayList<>();
        while (node != sentinel) {
            res.add(node.item);
            node = node.next;
        }
        return res;
    }

    public void addLast(T item) {
        DequeNode<T> oldLast = sentinel.prev;
        DequeNode<T> newLast = new DequeNode<>(item, oldLast, sentinel);
        sentinel.prev = newLast;
        oldLast.next = newLast;
        size += 1;
    }
}

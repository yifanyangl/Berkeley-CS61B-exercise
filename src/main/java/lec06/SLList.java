/*
Discussion 3
1.1 Implement SLList.insert which takes in an integer x and inserts it at the given position.
    If the position is after the end of the list, insert the new node at the end.
    For example, if the SLList is 5 → 6 → 2, insert(10, 1) results in 5 → 10 → 6 → 2.

1.2 Add another method to the SLList class that reverses the elements. Do this using the existing
    IntNodes (you should not use new).
 */
package lec06;

public class SLList {

    private class IntNode {

        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }

    }

    private IntNode sentinel;
    private int size;

    public SLList() {
        sentinel = new IntNode(56, null);
        size = 0;
    }

    public SLList(int... xArray) {
        sentinel = new IntNode(56, null);
        size = 0;
        for (int x : xArray) {
            addLast(x);
        }
    }

    public void addFirst(int x) {
        sentinel = new IntNode(x, sentinel);
        size += 1;
    }

    public void addLast(int x) {
        size = size + 1;

        IntNode p = sentinel;

        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
    }

    public void insert(int item, int position) {
        IntNode node = sentinel;
        for (int count = position; node.next != null && count > 0; count--) {
            node = node.next;
        }

        IntNode newNode = new IntNode(item, node.next);
        node.next = newNode;
        size += 1;
    }

    public int[] toArray() {
        int[] array = new int[size];

        IntNode rest = sentinel.next;
        for (int i = 0; i < size; i++) {
            array[i] = rest.item;
            rest = rest.next;
        }
        return array;
    }

    public void reverse() {
        // First node will become last
        IntNode newLastNode = sentinel.next;
        if (newLastNode == null) {
            return;
        }
        IntNode nodeToMove = newLastNode.next;

        while (nodeToMove != null) {
            newLastNode.next = nodeToMove.next;
            // Insert to front
            nodeToMove.next = sentinel.next;
            sentinel.next = nodeToMove;

            nodeToMove = newLastNode.next;
        }
    }

    public void reverseRecursive() {
        // Keep a reference to the first node to set its next to null in the end
        // The recursion helper method can not set that to null.
        IntNode oldFirst = sentinel.next;
        reverseRecursiveHelper(oldFirst);
        if (oldFirst != null) {
            oldFirst.next = null;
        }
    }

    private void reverseRecursiveHelper(IntNode node) {
        if (node == null) {
            return;
        }
        IntNode oldNext = node.next;
        node.next = sentinel.next;
        sentinel.next = node;
        reverseRecursiveHelper(oldNext);
    }
}

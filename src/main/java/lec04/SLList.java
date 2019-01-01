/*
B-level Exercise 1
Starting from the copy of SLList.java provided to you in the lecture code repository,
implement the method deleteFirst, which deletes the first element in your SLList.
Don’t forget to maintain the three invariants discussed above.

B-level Exercise 2
Starting from the copy of SLList.java provided to you in the lecture code repository,
implement a second constructor that takes in an array of integers,
and creates an SLList with those integers. Again, remember to maintain your invariants.

A-level Exercise 1
Do problem 5 from midterm 1 in Kartik’s textbook
(http://www.kartikkapur.com/documents/mt1.pdf#page=7)
We want to add a method to IntList so that if 2 numbers in a row are the
same, we add them together and make one large node. For example:
1 => 1 => 2 => 3 becomes 2 => 2 => 3 which becomes 4 => 3.
For this problem, you will not have access to any add, size, or remove method.
 */
package lec04;

/**
 * An SLList is a list of integers, which hides the terrible truth of the nakedness within.
 */
public class SLList {

    private static class IntNode {

        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /* The first item (if it exists) is at sentinel.next. */
    private IntNode sentinel;
    private int size;

    private static void lectureQuestion() {
        SLList L = new SLList();
        IntNode n = new IntNode(5, null);
    }

    /**
     * Creates an empty SLList.
     */
    public SLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public SLList(int[] xArray) {
        sentinel = new IntNode(63, null);
        size = 0;
        for (int x : xArray) {
            addLast(x);
        }
    }

    /**
     * Adds x to the front of the list.
     */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size = size + 1;
    }

    /**
     * Returns the first item in the list.
     */
    public int getFirst() {
        return sentinel.next.item;
    }

    /**
     * Adds x to the end of the list.
     */
    public void addLast(int x) {
        size = size + 1;

        IntNode p = sentinel;

        /* Advance p to the end of the list. */
        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
    }

    /**
     * Returns the size of the list.
     */
    public int size() {
        return size;
    }

    /**
     * Deletes the first element of the list.
     */
    public void deleteFirst() {
        if (sentinel.next != null) {
            sentinel.next = sentinel.next.next;
            size -= 1;
        }
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

    /**
     * Adds 2 numbers in a row if they are the same.
     *
     * <p>Does not use any add, size, or remove method.
     */
    public void addAdjacent() {
        if (size < 2) {
            return;
        }
        IntNode firstNode = sentinel.next;
        IntNode secNode = firstNode.next;
        while (secNode != null) {
            if (firstNode.item == secNode.item) {
                firstNode.item *= 2;
                firstNode.next = secNode.next;
                secNode = secNode.next;
                size -= 1;
            }

            firstNode = secNode;
            if (firstNode == null) {
                break;
            }
            secNode = secNode.next;
        }
    }

    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        SLList L = new SLList();
        L.addLast(20);
        System.out.println(L.size());
    }
}
